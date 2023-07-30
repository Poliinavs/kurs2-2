#define _WINSOCK_DEPRECATED_NO_WARNINGS
#include "Winsock2.h"
#include <iostream>
#include <clocale>
#include <ctime>

#include "ErrorMsgText.h"
#pragma comment(lib, "WS2_32.lib") 

int main()
{
    setlocale(LC_ALL, "rus");

    WSADATA wsaData;
    //SOCKET socket(
    //    int    af,   //[in]  формат адреса  
    //    int    type, //[in]  тип сокета  потоковый  
    //    int    prot  //[in]  протокол
    //);
    //int bind(
    //       SOCKET s,                    //[in] сокет
    //       const struct sockaddr_in* a, //[in] указатель на SOCKADDR_IN
    //       int    la                    //[in] длина SOCKADDR_IN в байтах
    //   );
        //int listen(
        //    SOCKET s,    //[in] дескриптор связанного сокета
        //    int    mcq,  //[in] максимальная длина очереди  из ожидающих сокетов              
        //    );
    SOCKET  sS;
    SOCKADDR_IN serv; //для работы с сокетами 
    serv.sin_family = AF_INET;  // тип сетевого адреса  IPv4
    serv.sin_port = htons(2000);  // номер порта                         
    serv.sin_addr.s_addr = INADDR_ANY; // IP-адрес                            

    try {
        if (WSAStartup(MAKEWORD(2, 0), &wsaData) != 0) { //инициализации библиотеки 1.версия которая будет использована  
            throw  SetErrorMsgText("Startup: ", WSAGetLastError());
        }
        if ((sS = socket(AF_INET, SOCK_STREAM, NULL)) == INVALID_SOCKET) { //создаем дескриптор сокет 
            throw  SetErrorMsgText("socket: ", WSAGetLastError());
        }
        if (bind(sS, (LPSOCKADDR)&serv, sizeof(serv)) == SOCKET_ERROR) {//установка параметров сокета и связывание 
            throw  SetErrorMsgText("bind: ", WSAGetLastError());
        }
        if (listen(sS, SOMAXCONN) == SOCKET_ERROR) { //сокет в режим ожидания
            throw SetErrorMsgText("listen: ", WSAGetLastError());
        }


        //подключился клиент
        //SOCKET accept(
        //    SOCKET s,             // [in]  дескриптор связанного сокета
        //    struct sockaddr_in* a,//[out] указатель на SOCKADDR_IN 
        //    int* la               //[out] указатель на длину SOCKADDR_IN                 
        //);
        //int recv(
        //    SOCKET s,        // [in] дескриптор сокета (канал для приема) 
        //    const char* buf, // [in] указатель буфер данных
        //    int  lbuf,       // [in] количество байт данных в буфере
        //    int  flags       // входной буфер очищается  после считывания данных 

        //);
        SOCKET cS;
        SOCKADDR_IN clnt;
        memset(&clnt, 0, sizeof(clnt));
        int lclnt = sizeof(clnt);

        clock_t start, end;
        char ibuf[50], obuf[50] = "server: принято ";
        int libuf = 0, lobuf = 0;
        bool flag = true;

        while (true) {
            cout << "ServerT\n\n";
            if ((cS = accept(sS, (sockaddr*)&clnt, &lclnt)) == INVALID_SOCKET) { //устанавливает подключение  между кдиентом и сервером возвращ нов дескриптор
                throw SetErrorMsgText("accept: ", WSAGetLastError());
            }
            cout << "         Client connect: " << endl; //клиент подключился 
            cout << "ADDRES client :          " << inet_ntoa(clnt.sin_addr) << " : " << htons(clnt.sin_port) << endl << endl << endl << endl << endl;
            while (true) {
                if ((libuf = recv(cS, ibuf, sizeof(ibuf), NULL)) == SOCKET_ERROR) { //принять данные от клиента возврат колич байт принятных даннвх
                    cout << "Client disconnect: " << GetErrorMsgText(WSAGetLastError()) << endl;
                    flag = true;
                    break;
                }

                if (flag) {
                    flag = false;
                    start = clock();//считаем 
                }

                string obuf = ibuf;
                if ((lobuf = send(cS, obuf.c_str(), strlen(obuf.c_str()) + 1, NULL)) == SOCKET_ERROR) {
                    throw SetErrorMsgText("send: ", WSAGetLastError());//отправляем клиенту
                }

                if (strcmp(ibuf, "") == 0) {
                    flag = true;
                    end = clock();
                    cout << "Time for send and recv: " << ((double)(end - start) / CLK_TCK) << " c\n\n"; //время 
                    break;
                }
                else {
                    cout << ibuf << endl;
                }
            }
        }
        //закрываем сокеты
        //SOCKET closesocket(
        //    SOCKET s   //[in] дескриптор сокета   
        //    );
        if (closesocket(sS) == SOCKET_ERROR) {
            throw  SetErrorMsgText("closesocket: ", WSAGetLastError());
        }
        if (closesocket(cS) == SOCKET_ERROR) {
            throw  SetErrorMsgText("closesocket: ", WSAGetLastError());
        }
        if (WSACleanup() == SOCKET_ERROR) {
            throw  SetErrorMsgText("Cleanup: ", WSAGetLastError());
        }
    }
    //Завершаем использование библиотеки
    catch (string errorMsgText) {
        cout << endl << errorMsgText;
    }

    system("pause");
    return 0;
}