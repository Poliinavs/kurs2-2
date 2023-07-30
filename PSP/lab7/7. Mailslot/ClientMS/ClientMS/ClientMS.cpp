#include <iostream>
#include <clocale>
#include <ctime>

#include "ErrorMsgText.h"
#include "Windows.h"

//#define NAME L"\\\\Polinavs\\mailslot\\Box"
#define NAME L"\\\\*\\mailslot\\Box"
#define STOP "STOP"

using namespace std;

int main()
{
    setlocale(LC_ALL, "rus");

    HANDLE cM;
    DWORD rb;
    clock_t start, end;
    char wbuf[500] = "Hello from Maislot-client";

    try {
        cout << "ClientMS\n\n";
        //HANDLE CreateFile
        //(
        //    LPCTSTR mname, // [in] символическое имя почтового ящика
        //    DWORD accss, // [in]  запись 
        //    DWORD share, // [in] режим совместного чтения
        //    LPSECURITY_ATTRIBUTES sattr // [in] атрибуты безопасности
        //    DWORD oflag, // [in] открытие существующего ящика
        //    DWORD aflag, // [in] флаги и атрибуты
        //    HANDLE exten, // [in] дополнительные атрибуты
        //    );

        if ((cM = CreateFile(NAME, GENERIC_WRITE, FILE_SHARE_READ, NULL, OPEN_EXISTING, NULL, NULL)) == INVALID_HANDLE_VALUE) {
            throw SetPipeError("CreateFile: ", GetLastError());
        }

        int countMessage;
        cout << "Number of messages: ";
        cin >> countMessage;

        for (int i = 1; i <= countMessage; i++) {
            if (i) {

                start = clock();
            }
            if (!WriteFile(cM, wbuf, sizeof(wbuf), &rb, NULL)) {
                throw SetPipeError("WriteFile: ", GetLastError());
            }

            cout << i << ". " << wbuf << endl;
        }

        if (!WriteFile(cM, STOP, sizeof(STOP), &rb, NULL)) {
            throw SetPipeError("WriteFile: ", GetLastError());
        }

        end = clock();
        cout << "Time for send and recv: " << ((double)(end - start) / CLK_TCK) << " c" << endl;


        if (!CloseHandle(cM)) {
            throw SetPipeError("CloseHandle: ", GetLastError());
        }

        system("pause");
    }
    catch (string ErrorPipeText) {
        cout << endl << ErrorPipeText;
    }
}
