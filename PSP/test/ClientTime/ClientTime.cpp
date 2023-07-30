﻿#define _WINSOCK_DEPRECATED_NO_WARNINGS
#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <tchar.h>
#include "iostream"
#include "Winsock2.h"                
#pragma comment(lib, "WS2_32.lib")   
#include <string>
#include <ctime>
#include "time.h"

using namespace std;
#define IP_SERV "172.20.10.15"

bool SystemMessage(char* ch) {

	bool result = false;
	try {

		char Timeout[50] = "Close: timeout;", Close[50] = "Close: finish;", Abort[50] = "Close: Abort;";
		if (strcmp(ch, Timeout) == 0) result = true;
		else if (strcmp(ch, Abort) == 0) result = true;
		else if (strcmp(ch, Close) == 0) result = true;
	}
	catch (...) {
		cout << "err" << endl;
	}

	return result;
}

string  GetErrorMsgText(int code) {
	string msgText;
	switch (code) {
	case WSAEINTR:                  msgText = "WSAEINTR";               break;    //Работа функции прервана
	case WSAEACCES:                 msgText = "WSAEACCES";              break;    //Разрешение отвергнуто
	case WSAEFAULT:                 msgText = "WSAEFAULT";              break;    //Ошибочный адрес
	case WSAEINVAL:                 msgText = "WSAEINVAL";              break;    //Ошибка в аргументе
	case WSAEMFILE:                 msgText = "WSAEMFILE";              break;    //Слишком много файлов открыто
	case WSAEWOULDBLOCK:            msgText = "WSAEWOULDBLOCK";         break;    //Ресурс временно недоступен
	case WSAEINPROGRESS:            msgText = "WSAEINPROGRESS";         break;    //Операция в процессе развития
	case WSAEALREADY:               msgText = "WSAEALREADY";            break;    //Операция уже выполняется
	case WSAENOTSOCK:               msgText = "WSAENOTSOCK";            break;    //Сокет задан неправильно
	case WSAEDESTADDRREQ:           msgText = "WSAEDESTADDRREQ";        break;    //Требуется адрес расположения
	case WSAEMSGSIZE:               msgText = "WSAEMSGSIZE";            break;    //Сообщение слишком длинное
	case WSAEPROTOTYPE:             msgText = "WSAEPROTOTYPE";          break;    //Неправильный тип протокола для сокета
	case WSAENOPROTOOPT:            msgText = "WSAENOPROTOOPT";         break;    //Ошибка в опции протокола
	case WSAEPROTONOSUPPORT:        msgText = "WSAEPROTONOSUPPORT";     break;    //Протокол не поддерживается
	case WSAESOCKTNOSUPPORT:        msgText = "WSAESOCKTNOSUPPORT";     break;    //Тип сокета не поддерживается
	case WSAEOPNOTSUPP:             msgText = "WSAEOPNOTSUPP";          break;    //Операция не поддерживается
	case WSAEPFNOSUPPORT:           msgText = "WSAEPFNOSUPPORT";        break;    //Тип протоколов не поддерживается
	case WSAEAFNOSUPPORT:           msgText = "WSAEAFNOSUPPORT";        break;    //Тип адресов не поддерживается протоколом
	case WSAEADDRINUSE:             msgText = "WSAEADDRINUSE";          break;    //Адрес уже используется
	case WSAEADDRNOTAVAIL:          msgText = "WSAEADDRNOTAVAIL";       break;    //Запрошенный адрес не может быть использован
	case WSAENETDOWN:               msgText = "WSAENETDOWN";            break;    //Сеть отключена
	case WSAENETUNREACH:            msgText = "WSAENETUNREACH";         break;    //Сеть не достижима
	case WSAENETRESET:              msgText = "WSAENETRESET";           break;    //Сеть разорвала соединение
	case WSAECONNABORTED:           msgText = "WSAECONNABORTED";        break;    //Программный отказ связи
	case WSAECONNRESET:             msgText = "WSAECONNRESET";          break;    //Связь восстановлена
	case WSAENOBUFS:                msgText = "WSAENOBUFS";             break;    //Не хватает памяти для буферов
	case WSAEISCONN:                msgText = "WSAEISCONN";             break;    //Сокет уже подключен
	case WSAENOTCONN:               msgText = "WSAENOTCONN";            break;    //Сокет не подключен
	case WSAESHUTDOWN:              msgText = "WSAESHUTDOWN";           break;    //Нельзя выполнить send: сокет завершил работу
	case WSAETIMEDOUT:              msgText = "WSAETIMEDOUT";           break;    //Закончился отведенный интервал  времени
	case WSAECONNREFUSED:           msgText = "WSAECONNREFUSED";        break;    //Соединение отклонено
	case WSAEHOSTDOWN:              msgText = "WSAEHOSTDOWN";           break;    //Хост в неработоспособном состоянии
	case WSAEHOSTUNREACH:           msgText = "WSAEHOSTUNREACH";        break;    //Нет маршрута для хоста
	case WSAEPROCLIM:               msgText = "WSAEPROCLIM";            break;    //Слишком много процессов
	case WSASYSNOTREADY:            msgText = "WSASYSNOTREADY";         break;    //Сеть не доступна
	case WSAVERNOTSUPPORTED:        msgText = "WSAVERNOTSUPPORTED";     break;    //Данная версия недоступна
	case WSANOTINITIALISED:         msgText = "WSANOTINITIALISED";      break;    //Не выполнена инициализация WS2_32.DLL
	case WSAEDISCON:                msgText = "WSAEDISCON";             break;    //Выполняется отключение
	case WSATYPE_NOT_FOUND:         msgText = "WSATYPE_NOT_FOUND";      break;    //Класс не найден
	case WSAHOST_NOT_FOUND:         msgText = "WSAHOST_NOT_FOUND";      break;    //Хост не найден
	case WSATRY_AGAIN:              msgText = "WSATRY_AGAIN";           break;    //Неавторизированный хост не найден
	case WSANO_RECOVERY:            msgText = "WSANO_RECOVERY";         break;    //Неопределенная  ошибка
	case WSANO_DATA:                msgText = "WSANO_DATA";             break;    //Нет записи запрошенного типа
	case WSA_INVALID_HANDLE:      msgText = "WSA_INVALID_HANDLE";     break;    //Указанный дескриптор события  с ошибкой
	case WSA_INVALID_PARAMETER:   msgText = "WSA_INVALID_PARAMETER";  break;    //Один или более параметров с ошибкой
	case WSA_IO_INCOMPLETE:       msgText = "WSA_IO_INCOMPLETE";      break;    //Объект ввода-вывода не в сигнальном состоянии
	case WSA_IO_PENDING:          msgText = "WSA_IO_PENDING";         break;    //Операция завершится позже
	case WSA_NOT_ENOUGH_MEMORY:   msgText = "WSA_NOT_ENOUGH_MEMORY";  break;    //Не достаточно памяти
	case WSA_OPERATION_ABORTED:   msgText = "WSA_OPERATION_ABORTED";  break;    //Операция отвергнута
	case WSASYSCALLFAILURE:         msgText = "WSASYSCALLFAILURE";      break;
	default:                msgText = "***ERROR***";      break;
	};
	return msgText;
}

string  SetErrorMsgText(string msgText, int code) {
	return  msgText + GetErrorMsgText(code);
}

string error = "Error";

string GetError() {
	return error;
};

const char* get_message(int msg)
{
	switch (msg)
	{
	case 1: return "Rand";
	case 2: return "Time";
	case 3: return "Echo";
	case 4: return "close";
	default:
		return "close";
	}
}


bool GetServer(char* call, SOCKADDR_IN* from, int* flen, SOCKET* cC, SOCKADDR_IN* all) {
	char ibuf[50], obuf[50];
	int  libuf = 0, lobuf = 0;

	if ((lobuf = sendto(*cC, call, strlen(call) + 1, NULL, (sockaddr*)all, sizeof(*all))) == SOCKET_ERROR) throw  SetErrorMsgText("Sendto:", WSAGetLastError());
	if ((libuf = recvfrom(*cC, ibuf, sizeof(ibuf), NULL, (sockaddr*)from, flen)) == SOCKET_ERROR) {
		if (WSAGetLastError() == WSAETIMEDOUT) return false;
		else throw  SetErrorMsgText("Recv:", WSAGetLastError());
	}
	if (strcmp(call, ibuf) == 0) return true;
	else return false;
}

int _tmain(int argc, _TCHAR* argv[]) {
	setlocale(LC_ALL, "Russian");
	int port = 0;
	SOCKET  SocketTCP;
	WSADATA wsaData;


	try {
		if (WSAStartup(MAKEWORD(2, 0), &wsaData) != 0) throw SetErrorMsgText("Startup:", WSAGetLastError());
		if ((SocketTCP = socket(AF_INET, SOCK_STREAM, NULL)) == INVALID_SOCKET) throw  SetErrorMsgText("Socket:", WSAGetLastError());

		int ch = 0, cCall = 0;

		int max = 100, lobuf = 1, bport = 2000;
		char obuf[50] = "", ibuf[50] = "", Call[50], Name[50], call[50];

		SOCKADDR_IN Server = { 0 };
		Server.sin_family = AF_INET;
		Server.sin_port = htons(port);

		SOCKADDR_IN Server_IN;
		int Flen = sizeof(Server), connectionType = 0;
		cout << "1 - Подключение по имени сервера" << endl << "2 - Подключение по позывному" << endl;
		cin >> connectionType;
		//
		//connectionType = 1;
		//
		if (connectionType == 1) {
			std::cout << "Введите имя сервера: ";
			std::cin >> Name;

			hostent* s = gethostbyname(Name);
			//hostent* s = gethostbyname("Polinavs");
			if (s == NULL) throw "Сервер не найден;";
			std::cout << "Порт сервера: ";
			//std::cin >> port;
			port = 2000;
			Server_IN.sin_addr = *(struct in_addr*)s->h_addr_list[0];
		}
		else if (connectionType == 2) {
			cout << "Введите позывной сервера: ";
			cin >> call;

			SOCKET SocketUDP;
			int optval = 1;
			if ((SocketUDP = socket(AF_INET, SOCK_DGRAM, NULL)) == INVALID_SOCKET) throw SetErrorMsgText("Socket:", WSAGetLastError());
			if (setsockopt(SocketUDP, SOL_SOCKET, SO_BROADCAST, (char*)&optval, sizeof(int)) == SOCKET_ERROR) throw SetErrorMsgText("Opt:", WSAGetLastError());

			SOCKADDR_IN all;
			all.sin_family = AF_INET;
			all.sin_port = htons(bport);
			all.sin_addr.s_addr = inet_addr("127.0.0.1"); //172.20.10.15
			//all.sin_addr.s_addr = inet_addr("192.168.43.120");
			SOCKADDR_IN from;

			memset(&from, 0, sizeof(from));
			int lc = sizeof(from);

			bool bsr = GetServer(call, &from, &lc, &SocketUDP, &all);
			if (bsr == false) {
				throw "Server not found;";
			}
			else {
				Server_IN.sin_addr.s_addr = from.sin_addr.s_addr;
				if (closesocket(SocketUDP) == SOCKET_ERROR) throw SetErrorMsgText("Closesocket:", WSAGetLastError());
				cout << "Порт сервера: ";
				cin >> port;
			}
		}
		else {
			throw "Wrong code";
		}

		Server_IN.sin_family = AF_INET;
		Server_IN.sin_port = htons(port);

		if ((connect(SocketTCP, (sockaddr*)&Server_IN, sizeof(Server_IN))) == SOCKET_ERROR) throw "Ошибка соединения;";


		while (true)
		{
			char message[50],
				obuf[50];
			int libuf = 0,
				lobuf = 0;

			puts("Choose");
			int service;
			puts("1 - Rand\n2 - Time\n3 - Echo\n4 - close socket");

			scanf("%d", &service);
			char* outMessage = new char[5];
			strcpy(outMessage, get_message(service));
			/*if ((lobuf = send(SocketTCP, Call, sizeof(Call), NULL)) == SOCKET_ERROR) throw SetErrorMsgText("Send:", WSAGetLastError());
		char rCall[50];
		if ((lobuf = recv(SocketTCP, rCall, sizeof(rCall), NULL)) == SOCKET_ERROR) throw SetErrorMsgText("Recv:", WSAGetLastError());
		*/

			if ((lobuf = send(SocketTCP, outMessage, strlen(outMessage) + 1, NULL)) == SOCKET_ERROR)
				throw SetErrorMsgText("send:", WSAGetLastError());


			printf("sended: %s\n", outMessage);

			if ((libuf = recv(SocketTCP, message, sizeof(message), NULL)) == SOCKET_ERROR)
				throw SetErrorMsgText("recv:", WSAGetLastError());

			if (service != 1 && service != 2 && service != 3)
			{
				error = "ErrorInquary";
				break;
			}

			if (!strcmp(message, "TimeOUT"))
			{
				puts("time out");
				return -1;
			}
			if (service == 3)
			{
				for (int j = 30; j >= 0; --j)
				{
					Sleep(1000);
					sprintf(outMessage, "%d", j);
					if ((lobuf = send(SocketTCP, outMessage, strlen(outMessage) + 1, NULL)) == SOCKET_ERROR)
						throw SetErrorMsgText("send:", WSAGetLastError());
					printf("send: %s\n", outMessage);
					if ((libuf = recv(SocketTCP, message, sizeof(message), NULL)) == SOCKET_ERROR)
						throw SetErrorMsgText("recv:", WSAGetLastError());
					cout << "Send from client";
				}
			}
			else if (service == 2 || service == 1)
			{

				printf("receive: %s\n", message);
				if ((lobuf = send(SocketTCP, outMessage, strlen(outMessage) + 1, NULL)) == SOCKET_ERROR)
					throw SetErrorMsgText("send:", WSAGetLastError());
				if ((libuf = recv(SocketTCP, message, sizeof(message), NULL)) == SOCKET_ERROR)
					throw SetErrorMsgText("recv:", WSAGetLastError());
				printf("receive: %s\n", message);
			}
		}

	
		if (closesocket(SocketTCP) == SOCKET_ERROR) throw SetErrorMsgText("Closesocket:", WSAGetLastError());
		if (WSACleanup() == SOCKET_ERROR) throw SetErrorMsgText("Cleanup:", WSAGetLastError());
	}
	catch (char* errorMsgText) {
		cout << errorMsgText << endl;
	}
	catch (...) {
		cout << error << endl;
	}

	system("pause");
	return 0;
}