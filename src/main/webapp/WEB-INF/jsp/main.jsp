<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tiles:importAttribute/>
<html>
<head>
    <title>Название</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body style="margin: 0;">
<div style="border-top: 5px solid #7e7e7e;"></div>
<div style="padding: 20px;">
    <div style="max-width: 1000px; margin: auto; ">
        <div style="display: inline-block; padding: 0 10px; float: left;"><a href="/">LOGO</a></div>
        <div style="display: inline-block; padding: 0 10px; float: right;"><a href="#login_form" id="login_pop"><button class="login" type="submit">Login</button></a></div>
        <div style="display: inline-block; padding: 0 10px; float: right;"><a href="/">Registration</a></div>
    </div>
</div>
<div style="background: #f8f8f8; margin: 10px 0;">
    <div style="max-width: 1000px; margin: auto; padding: 100px;">
        <div style="display: inline-block; float: left">
            <p>Bla Bla Bla
                Bla Bla Bla
                Bla Bla Bla
                Bla Bla Bla
                Bla Bla Bla</p>
            <p>Bla Bla Bla
                Bla Bla Bla
                Bla Bla Bla
                Bla Bla Bla
                Bla Bla Bla
                Bla Bla Bla</p>
        </div>
        <div style="border: 100px solid gray;display: inline-block; margin: 0 100px;">
        </div>
    </div>
</div>
<a href="#x" class="overlay" id="login_form"></a>
<div class="popup">
    <html:form action="/login">
        <h2>Вход</h2>
        Введите ваш логин и пароль
        <div>
            Логин
            <html:text property="login" title="login"/>
        </div>
        <div>
            Пароль
            <html:text property="password" title="password"/>
        </div>
        <html:submit value="Login"/>
        <a class="close" href="#close"></a>
    </html:form>
</div>
<div style="margin: 10px 0;">
    <div style="max-width: 1000px; margin: auto; padding: 100px;">
        <div style="display: inline-block; float: left">
            <p>Bla Bla Bla
                Bla Bla Bla
                Bla Bla Bla
                Bla Bla Bla
                Bla Bla Bla</p>
            <p>Bla Bla Bla
                Bla Bla Bla
                Bla Bla Bla
                Bla Bla Bla
                Bla Bla Bla
                Bla Bla Bla</p>
        </div>
        <div style="border: 100px solid gray;display: inline-block; margin: 0 100px;">
        </div>
    </div>
    <div style="background: #f8f8f8; margin: 10px 0;">
        <div style="max-width: 1000px; margin: auto; padding: 100px;">
            <div style="display: inline-block; float: left">
                <p>Bla Bla Bla
                    Bla Bla Bla
                    Bla Bla Bla
                    Bla Bla Bla
                    Bla Bla Bla</p>
                <p>Bla Bla Bla
                    Bla Bla Bla
                    Bla Bla Bla
                    Bla Bla Bla
                    Bla Bla Bla
                    Bla Bla Bla</p>
            </div>
            <div style="border: 100px solid gray;display: inline-block; margin: 0 100px;">
            </div>
        </div>
    </div>
</div>
<footer style="background: #7e7e7e; color: #dbdbdb; font-size: 11px;">
    <div style="max-width: 1000px; margin: auto; padding: 10px 0; height: 90px;">
        <div style="float: left; width: 300px;">
            <h3 style="font: 14px 'Oswald', sans-serif; color: #fff; border-bottom: 1px solid #919191; margin: 0 0 10px 0;">
                TWITTER FEED
            </h3>
            <p style="padding-right: 15px;">Bla Bla Bla Bla</p>
        </div>
        <div style="width: 150px; float: left; margin-left: 20px; padding-right: 15px;">
            <h3 style="    font: 14px 'Oswald', sans-serif; color: #fff; border-bottom: 1px solid #919191; margin: 0 0 10px 0;">
                SITEMAP
            </h3>
            <div style="display: inline-block;">
                <a style="display: block; text-decoration: none; font-size: 12px; margin-bottom: 5px; color: #dbdbdb;"
                   href="/home/">Home</a>
                <a style="display: block; text-decoration: none; font-size: 12px; margin-bottom: 5px; color: #dbdbdb;"
                   href="/about/">About</a>
                <a style="display: block; text-decoration: none; font-size: 12px; margin-bottom: 5px; color: #dbdbdb;"
                   href="/services/">Services</a>
            </div>
            <div style="display: inline-block; margin-left: 40px;">
                <a style="display: block; text-decoration: none; font-size: 12px; margin-bottom: 5px; color: #dbdbdb;"
                   href="/home/">Home</a>
                <a style="display: block; text-decoration: none; font-size: 12px; margin-bottom: 5px; color: #dbdbdb;"
                   href="/about/">About</a>
                <a style="display: block; text-decoration: none; font-size: 12px; margin-bottom: 5px; color: #dbdbdb;"
                   href="/services/">Services</a>
            </div>
        </div>
        <div style="float: right; margin-top: 20px; font-size: 10px; text-align: right;">
            <a style="color: #dbdbdb;" href="/">LOGO</a>
            <p style="margin: 5px 0;">
                Copyright © 2012 Whitesquare. A pcklab creation
            </p>
        </div>
    </div>
</footer>
</body>
</html>
