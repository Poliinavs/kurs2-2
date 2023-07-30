#pragma once
#include "Global.h"

//Принимающая только символьную последовательность  time и отвечающая  системным значением даты и времени серверного компьютера в формате: dd.mm.yyyy/hh:mm:ss.
//Условие завершение работы: прием любой последовательности символов, отличной от   time.     
DWORD WINAPI TimeServer(LPVOID lParam) {

	DWORD rc = 0;		// Код возврата
	Contact* client = (Contact*)lParam;

	QueueUserAPC(ASStartMessage, client->hAcceptServer, (DWORD)client);	// Ставим в очередь сообщение о старте обслуживания
	try {
		client->sthread = Contact::WORK;
		int  bytes = 1;
		char ibuf[50], obuf[50] = "Close: finish;", Time[50] = "Time";
		// Принимаем данные из сокета
		int i = 0;
		/*while (client->TimerOff == false) {

			if ((bytes = recv(client->s, ibuf, sizeof(ibuf), NULL)) == SOCKET_ERROR) {
				switch (WSAGetLastError()) {
				case WSAEWOULDBLOCK: Sleep(100); break;
				default: throw  SetErrorMsgText("Recv:", WSAGetLastError());
				}
			}
			else {
				if (strcmp(ibuf, "Time") == 0) {

					if (client->TimerOff != false) {
						break;
					}

					SYSTEMTIME stt;
					GetLocalTime(&stt);
				sprintf_s(ibuf, "%s %d.%d.%d/%d:%02d:%d", Time, stt.wDay, stt.wMonth, stt.wYear, stt.wHour, stt.wMinute, stt.wSecond);

					if ((send(client->s, ibuf, sizeof(ibuf), NULL)) == SOCKET_ERROR) throw  SetErrorMsgText("Send:", WSAGetLastError());

				}
				else break;
			}
		}*/

		while (client->TimerOff == false) {	// Принимаем данные из сокета
			if (recv(client->s, ibuf, sizeof(ibuf), NULL) == SOCKET_ERROR) {// Принимаем данные
				if (WSAGetLastError() == WSAEWOULDBLOCK) Sleep(100);
				else throw  SetErrorMsgText("Recv:", WSAGetLastError());
			}
			else {
				if (strcmp(ibuf, "exit") != 0) {
					if (client->TimerOff != false) break;	// Проверяем метку срабатывания таймера
					if (i != 25) {
						SYSTEMTIME stt;
						GetLocalTime(&stt);
						sprintf_s(ibuf, "%s %d.%d.%d/%d:%02d:%d", Time, stt.wDay, stt.wMonth, stt.wYear, stt.wHour, stt.wMinute, stt.wSecond);
					
						
						if ((send(client->s, ibuf, sizeof(ibuf), NULL)) == SOCKET_ERROR) throw  SetErrorMsgText("Send:", WSAGetLastError());// Отправляем обратно
						i++;
					}
					else {
						if ((send(client->s, obuf, sizeof(obuf), NULL)) == SOCKET_ERROR) throw  SetErrorMsgText("Send:", WSAGetLastError());
					}
				
				}
				else break;
			}
		}
	
		if (client->TimerOff == false) {

			CancelWaitableTimer(client->htimer);// Отключаем таймер
			if ((send(client->s, obuf, sizeof(obuf) + 1, NULL)) == SOCKET_ERROR) throw  SetErrorMsgText("Send:", WSAGetLastError());

			client->sthread = Contact::FINISH;// Ставим метку удачного завершения
			QueueUserAPC(ASFinishMessage, client->hAcceptServer, (DWORD)client);
		}
	}
	catch (string errorMsgText) {
		std::cout << errorMsgText << std::endl;
		CancelWaitableTimer(client->htimer);
		client->sthread = Contact::ABORT;
	}
	ExitThread(rc);	// Завершаем поток
}