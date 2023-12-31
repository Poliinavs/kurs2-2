﻿#include <iostream>
#include <clocale>
#include <ctime>

#include "ErrorMsgText.h"
#include "Windows.h"

#define NAME L"\\\\.\\mailslot\\Box"

using namespace std;

int main()
{
    setlocale(LC_ALL, "rus");
     
    HANDLE sH;
    DWORD rb,
        time = 180000, //MAILSLOT_WAIT_FOREVER
        nMaxMessageSize = 400;   
    clock_t start, end;
    char rbuf[400];
    bool flag = true;
    int i = 0;
    //HANDLE CreateMailslot
    //(
    //    LPCTSTR pname, // [in] символическое имя ящика
    //    DWORD maxms, // [in] максимальная длина сообщения 
    //    DWORD timeo, // [in] интервал ожидания
    //    LPSECURITY_ATTRIBUTES sattr // [in] атрибуты безопасности
    //);
    try {
        cout << "ServerMS\n\n";

        if ((sH = CreateMailslot(NAME, nMaxMessageSize, time, NULL)) == INVALID_HANDLE_VALUE) {
            throw SetPipeError("CreateMailslot: ", GetLastError());
        }
        while (true) {
            if (!ReadFile(sH, rbuf, sizeof(rbuf), &rb, NULL)) {
                    throw SetPipeError("ReadFile: ", GetLastError());
            }
            else {
                if (flag) {
                    start = clock();
                    flag = false;
                }
            }
            if (strcmp(rbuf, "STOP") == 0)
            {
                end = clock();
                cout << "Time for send and recv: " << ((double)(end - start) / CLK_TCK) << " c" << endl;
                flag = true;
            }
            cout << rbuf << endl;
            i++;
        }
        if (!CloseHandle(sH)) {
            throw SetPipeError("CloseHandle: ", GetLastError());
        }

        system("pause");
    }
    catch (string ErrorPipeText) {
        cout << endl << ErrorPipeText;
    }
}

