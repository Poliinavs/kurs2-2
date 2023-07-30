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
    //    int    af,   //[in]  ������ ������  
    //    int    type, //[in]  ��� ������  ���������  
    //    int    prot  //[in]  ��������
    //);
    //int bind(
    //       SOCKET s,                    //[in] �����
    //       const struct sockaddr_in* a, //[in] ��������� �� SOCKADDR_IN
    //       int    la                    //[in] ����� SOCKADDR_IN � ������
    //   );
        //int listen(
        //    SOCKET s,    //[in] ���������� ���������� ������
        //    int    mcq,  //[in] ������������ ����� �������  �� ��������� �������              
        //    );
    SOCKET  sS;
    SOCKADDR_IN serv; //��� ������ � �������� 
    serv.sin_family = AF_INET;  // ��� �������� ������  IPv4
    serv.sin_port = htons(2000);  // ����� �����                         
    serv.sin_addr.s_addr = INADDR_ANY; // IP-�����                            

    try {
        if (WSAStartup(MAKEWORD(2, 0), &wsaData) != 0) { //������������� ���������� 1.������ ������� ����� ������������  
            throw  SetErrorMsgText("Startup: ", WSAGetLastError());
        }
        if ((sS = socket(AF_INET, SOCK_STREAM, NULL)) == INVALID_SOCKET) { //������� ���������� ����� 
            throw  SetErrorMsgText("socket: ", WSAGetLastError());
        }
        if (bind(sS, (LPSOCKADDR)&serv, sizeof(serv)) == SOCKET_ERROR) {//��������� ���������� ������ � ���������� 
            throw  SetErrorMsgText("bind: ", WSAGetLastError());
        }
        if (listen(sS, SOMAXCONN) == SOCKET_ERROR) { //����� � ����� ��������
            throw SetErrorMsgText("listen: ", WSAGetLastError());
        }


        //����������� ������
        //SOCKET accept(
        //    SOCKET s,             // [in]  ���������� ���������� ������
        //    struct sockaddr_in* a,//[out] ��������� �� SOCKADDR_IN 
        //    int* la               //[out] ��������� �� ����� SOCKADDR_IN                 
        //);
        //int recv(
        //    SOCKET s,        // [in] ���������� ������ (����� ��� ������) 
        //    const char* buf, // [in] ��������� ����� ������
        //    int  lbuf,       // [in] ���������� ���� ������ � ������
        //    int  flags       // ������� ����� ���������  ����� ���������� ������ 

        //);
        SOCKET cS;
        SOCKADDR_IN clnt;
        memset(&clnt, 0, sizeof(clnt));
        int lclnt = sizeof(clnt);

        clock_t start, end;
        char ibuf[50], obuf[50] = "server: ������� ";
        int libuf = 0, lobuf = 0;
        bool flag = true;

        while (true) {
            cout << "ServerT\n\n";
            if ((cS = accept(sS, (sockaddr*)&clnt, &lclnt)) == INVALID_SOCKET) { //������������� �����������  ����� �������� � �������� ������� ��� ����������
                throw SetErrorMsgText("accept: ", WSAGetLastError());
            }
            cout << "         Client connect: " << endl; //������ ����������� 
            cout << "ADDRES client :          " << inet_ntoa(clnt.sin_addr) << " : " << htons(clnt.sin_port) << endl << endl << endl << endl << endl;
            while (true) {
                if ((libuf = recv(cS, ibuf, sizeof(ibuf), NULL)) == SOCKET_ERROR) { //������� ������ �� ������� ������� ����� ���� ��������� ������
                    cout << "Client disconnect: " << GetErrorMsgText(WSAGetLastError()) << endl;
                    flag = true;
                    break;
                }

                if (flag) {
                    flag = false;
                    start = clock();//������� 
                }

                string obuf = ibuf;
                if ((lobuf = send(cS, obuf.c_str(), strlen(obuf.c_str()) + 1, NULL)) == SOCKET_ERROR) {
                    throw SetErrorMsgText("send: ", WSAGetLastError());//���������� �������
                }

                if (strcmp(ibuf, "") == 0) {
                    flag = true;
                    end = clock();
                    cout << "Time for send and recv: " << ((double)(end - start) / CLK_TCK) << " c\n\n"; //����� 
                    break;
                }
                else {
                    cout << ibuf << endl;
                }
            }
        }
        //��������� ������
        //SOCKET closesocket(
        //    SOCKET s   //[in] ���������� ������   
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
    //��������� ������������� ����������
    catch (string errorMsgText) {
        cout << endl << errorMsgText;
    }

    system("pause");
    return 0;
}