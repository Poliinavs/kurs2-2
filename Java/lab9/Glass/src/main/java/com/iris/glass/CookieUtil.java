package com.iris.glass;

import jakarta.servlet.http.Cookie;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class CookieUtil {
    public static void addUserInfoToCookie(HttpServletRequest request, HttpServletResponse response, String userType) throws IOException {
        // Получение текущей даты и времени
        Date currentDate = new Date();

        // Получение значения счетчика посещений из файла cookie
        int visitCount = 0;
        jakarta.servlet.http.Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (jakarta.servlet.http.Cookie cookie : cookies) {
                if (cookie.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
        }

        // Увеличение значения счетчика посещений на 1
        visitCount++;

        // Создание нового файла cookie с информацией о времени и дате последнего сеанса, количестве посещений и типе пользователя
        Cookie userInfoCookie = new Cookie("userInfo", "User Type: " + userType + ", Last Session Time: " + currentDate.toString() + ", Visit Count: " + visitCount);

        // Установка срока жизни файла cookie (например, на 1 день)
        userInfoCookie.setMaxAge(24 * 60 * 60);

        // Добавление файла cookie в ответ сервера
        response.addCookie(userInfoCookie);

        // Отправка ответа сервера
        response.sendRedirect("index.jsp"); // Здесь можно указать страницу, на которую пользователь будет перенаправлен после добавления файла cookie
    }
}
