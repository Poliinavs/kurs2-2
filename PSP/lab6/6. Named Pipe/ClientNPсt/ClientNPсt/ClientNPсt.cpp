﻿#include <iostream>
#include <clocale>
#include <ctime>

#include "ErrorMsgText.h"
#include "Windows.h"

#define STOP "STOP"
//#define NAME L"\\\\DESKTOP-E4TFQEB\\pipe\\Tube"
#define NAME L"\\\\Polinavs\\pipe\\Tube"

using namespace std;
//BOOL CallNamedPipe
//(
//    LPCTSTR nP, // [in] указатель на имя канала
//    LPVOID pw, // [in] указатель на буфер для записи
//    DWORD sw, // [in] размер буфера для записи
//    LPVOID pr, // [out] указатель на буфер для чтения 
//    DWORD sr, // [in] размер буфера для чтения
//    LPDWORD pr, // [out] количество прочитанных байт
//    DWORD to // [in] интервал ожидания 
//);
int main()
{
    setlocale(LC_ALL, "rus");

    HANDLE cH;
    DWORD lp;
    char ibuf[50], obuf[50];

    try {
        cout << "ClientNPсt\n\n";

        int countMessage;
        cout << "Number of messages: ";
        cin >> countMessage;

        for (int i = 1; i <= countMessage; i++) {
            string obufstr = "start" + to_string(i);
            strcpy_s(obuf, obufstr.c_str());

            if (!CallNamedPipe(NAME, obuf, sizeof(obuf), ibuf, sizeof(ibuf), &lp, NMPWAIT_WAIT_FOREVER)) {
                throw SetPipeError("CallNamedPipe: ", GetLastError());
            }

            cout << ibuf << endl;
        }

        system("pause");
    }
    catch (string ErrorPipeText) {
        cout << endl << ErrorPipeText;
    }
}