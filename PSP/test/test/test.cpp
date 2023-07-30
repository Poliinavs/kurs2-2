#include <iostream>
#include <clocale>
#include <ctime>

//#include "ErrorMsgText.h"
#include "Windows.h"
#include <string>


#define NAME L"\\\\Polinavs\\pipe\\Tube"
//#define NAME L"\\\\.\\pipe\\Tube"
//#define NAME L"\\\\WIN-C8KN43FVVVS\\pipe\\Tube"
#define STOP "STOP"

using namespace std;

string GetErrorMsgText(int code) // cформировать текст ошибки
{
    char buff[50];
    DWORD bufflen = sizeof(buff);

    DWORD errorMessageID = ::GetLastError();
    if (errorMessageID == 0) {
        return std::string(); //No error message has been recorded
    }
    else {
        return std::system_category().message(errorMessageID);
    }
};


string SetPipeError(string msgText, int code)
{
    return msgText + to_string(code) + ". " + GetErrorMsgText(code);
};

int main()
{
    setlocale(LC_ALL, "rus");

    HANDLE cH=NULL;
    DWORD lp;
    char buf[50];
    //    HANDLE CreateFile
    //(
    //    LPCTSTR pname, // [in] символическое имя канала 
    //    DWORD accss, // [in] чтение или запись в канал
    //    DWORD share, // [in] режим совместного использования
    //    LPSECURITY_ATTRIBUTES sattr // [in] атрибуты безопасности
    //    DWORD oflag, // [in] флаг открытия канала открытие существующего канала
    //    DWORD aflag, // [in] флаги и атрибуты
    //    HANDLE exten, // [in] дополнительные атрибуты
    //    );
     //BOOL WriteFile
    //(
    //    HANDLE hP, // [in] дескриптор канала
    //    LPVOID pb, // [in] указатель на буфер вывода
    //    DWORD sb, // [in] количество записываемых байт
    //    LPDWORD ps, // [out] количество записанных байт
    //    LPOVERLAPPED ol // [in,out] для асинхронной обработки
    //);
    try {
        using namespace std;
        cout << "ClientNP\n\n";



        string obuf = "";
        int a = 0;
        cout << "\n -------------------------------------------- \n";
        cout << "1 - start  \t\n";
        cout << "2 - stop  \t\n";
        cout << "3 - exit  \t\n";
        cout << "4 - statistics\t\n";
        cout << "5 - wait  \t\n";
        cout << "6 - shutdown  \t\n";
    
        cout << "\n ------------------------------------------- \n";
       
        while (obuf != "exit") {
            cin >> a;
            if (a < 1 || a>6) {
                cout << "\nIncorrect\ntry again";
                return main();
            }




            switch (a) {
            case 1: {
                obuf = "start";
               
                break;
            }
            case 2:
                obuf = "stop";
               
                break;
            case 3:

                obuf = "exit";
             
                break;
            case 4:
                obuf = "statistics";
             
                break;
            case 5:

                obuf = "wait";
               
                break;
            case 6:

                obuf = "shutdown";
               
                break;

            }

            if ((cH = CreateFile(NAME, GENERIC_READ | GENERIC_WRITE,
                FILE_SHARE_READ | FILE_SHARE_WRITE,
                NULL, OPEN_EXISTING, NULL, NULL)) == INVALID_HANDLE_VALUE) {
                throw  SetPipeError("CreateFile: ", GetLastError());
            }
            if (!WriteFile(cH, obuf.c_str(), sizeof(obuf), &lp, NULL)) {
                throw SetPipeError("WriteFile: ", GetLastError());
            }
            if (!ReadFile(cH, buf, sizeof(buf), &lp, NULL)) {
                throw SetPipeError("ReadFile: ", GetLastError());
            }
            cout << "receve:" << buf<<endl;
        }
        if (!CloseHandle(cH)) {
            throw SetPipeError("CloseHandle: ", GetLastError());
        }

        system("pause");
    }
    catch (string ErrorPipeText) {
        cout << endl << SetPipeError;
    }
}

//#include <stdio.h>
//#include <tchar.h>
//#include "iostream"
//#include "Windows.h"                
//#include "ctime"
//#include <string>
//using std::string;
//using namespace std;
//#define NAME L"\\\\Polinavs\\pipe\\Tube"
//string GetErrorMgText(int code) // cформировать текст ошибки
//{
//	char buff[50];
//	DWORD bufflen = sizeof(buff);
//	DWORD errorMessageID = ::GetLastError();
//	if (errorMessageID == 0) {
//		return std::string(); //No error message has been recorded
//	}
//	else {
//		return std::system_category().message(errorMessageID);
//	}
//};
//string SetPipeError(string msgText, int code)
//{
//	return msgText + to_string(code) + ". " + GetErrorMgText(code);
//};
//
//
//int _tmain(int argc, _TCHAR* argv[]) {
//	setlocale(LC_ALL, "Russian");
//
//	char ReadBuf[50] = "";
//	char WriteBuf[2] = "";
//	DWORD nBytesRead;
//	DWORD nBytesWrite;
//
//#pragma region SecurityAttributes
//	SECURITY_DESCRIPTOR* m_pSecDesc = (SECURITY_DESCRIPTOR*)LocalAlloc(LPTR, SECURITY_DESCRIPTOR_MIN_LENGTH);
//	SECURITY_ATTRIBUTES m_pSecAttrib = { sizeof(SECURITY_ATTRIBUTES), m_pSecDesc, TRUE };
//	InitializeSecurityDescriptor(m_pSecDesc, SECURITY_DESCRIPTOR_REVISION);
//	SetSecurityDescriptorDacl(m_pSecDesc, TRUE, (PACL)NULL, FALSE);
//#pragma endregion
//
//
//	int Code = 0;
//
//	char serverName[256];
//	char PipeName[512];
//	bool result;
//
//	try
//	{
//		printf_s("\n -------------------------------------------- \n");
//		printf_s("1 - start  \t\n");
//		printf_s("2 - stop  \t\n");
//		printf_s("3 - exit  \t\n");
//		printf_s("4 - statistics\t\n");
//		printf_s("5 - wait  \t\n");
//		printf_s("6 - shutdown  \t\n");
//		printf_s("0 - exit\n");
//		printf_s("\n ------------------------------------------- \n");
//
//	/*	cout << "Введите имя севера: ";
//		cin >> serverName;
//		result = sprintf_s(PipeName, "\\\\%s\\pipe\\cpipe", serverName);*/
//
//
//		HANDLE hNamedPipe = CreateFile(NAME, GENERIC_READ | GENERIC_WRITE, 0, NULL, OPEN_EXISTING, 0, &m_pSecAttrib);
//
//		do {
//			printf_s("Команда: ");
//			scanf_s("%d", &Code);
//			if (Code > 0 && Code < 7) {
//				sprintf_s(WriteBuf, "%d", Code - 1);
//				if (!WriteFile(hNamedPipe, WriteBuf, strlen(WriteBuf) + 1, &nBytesWrite, NULL)) throw "WriteFile: Ошибка ";
//				if (!ReadFile(hNamedPipe, ReadBuf, sizeof(ReadBuf), &nBytesRead, NULL)) throw "ReadFile: Ошибка ";
//				cout << ReadBuf << endl;
//			}
//			if (Code == 0) break;
//		} while (true);
//
//		if (!CloseHandle(hNamedPipe)) throw SetPipeError("CloseHandle: ", GetLastError());
//	}
//	catch (string ErrorPipeText)
//	{
//		cout << endl << ErrorPipeText;
//	}
//	cout << "RConsole остановлена\n\n";
//	return 0;
//}
