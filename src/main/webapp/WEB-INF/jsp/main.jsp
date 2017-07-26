<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tiles:importAttribute/>
<html>
<head>
    <title>Название</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<%--<body>--%>

    <%--<div id="wrapper" class="wrapper">--%>
        <%--<jsp:include page="header.jsp"/>--%>
        <%--<div>--%>
            <%--<tiles:insert attribute="data"/>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<jsp:include page="footer.jsp"/>--%>
<%--</body>--%>

<body>
<div id="wrapper">
    <jsp:include page="header.jsp"/>

    <section>
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
        <%--<blockquote>--%>
            <%--<p>--%>
                <%--&ldquo;QUISQUE IN ENIM VELIT, AT DIGNISSIM EST.--%>
                <%--NULLA UL CORPER, DOLOR AC PELLENTESQUE PLACERAT, JUSTO TELLUS GRAVIDA ERAT, VEL PORTTITOR LIBERO ERAT.&rdquo;--%>
            <%--</p>--%>
            <%--<cite>John Doe, Lorem Ipsum</cite>--%>
        <%--</blockquote>--%>

        <p class="p-style">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean non neque ac sem accumsan rhoncus ut ut turpis. In hac habitasse platea dictumst. Proin eget nisi erat, et feugiat arcu. Duis semper porttitor lectus, ac pharetra erat imperdiet nec. Morbi interdum felis nulla. Aenean eros orci, pellentesque sed egestas vitae, auctor aliquam nisi. Nulla nec libero eget sem rutrum iaculis. Quisque in enim velit, at dignissim est. Nulla ullamcorper, dolor ac pellentesque placerat, justo tellus gravida erat, vel porttitor libero erat condimentum metus. Donec sodales aliquam orci id suscipit. Proin sed risus sit amet massa ultrices laoreet quis a erat. Aliquam et metus id erat vulputate egestas. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>
        <p class="p-style">Donec vel nisl nibh. Aenean quam tortor, tempus sit amet mattis dapibus, egestas tempor dui. Duis vestibulum imperdiet risus pretium pretium. Nunc vitae porta ligula. Vestibulum sit amet nulla quam. Aenean lacinia, ante vitae sodales sagittis, leo felis bibendum neque, mattis sagittis neque urna vel magna. Sed at sem vitae lorem blandit feugiat.</p>
        <p class="p-style">Donec vel orci purus, ut ornare orci. Aenean rutrum pellentesque quam. Quisque gravida adipiscing augue, eget commodo augue egestas varius. Integer volutpat, tellus porta tincidunt sodales, lacus est tempus odio, fringilla blandit tortor lectus ut sem. Pellentesque nec sem lacus, sit amet consequat neque. Etiam varius urna quis arcu cursus in consectetur dui tincidunt. Quisque arcu orci, lacinia eget pretium vel, iaculis pellentesque nibh. Etiam cursus lacus eget neque viverra vestibulum. Aliquam erat volutpat. Duis pulvinar tellus ut urna facilisis mollis. Maecenas ac pharetra dui. Pellentesque neque ante, luctus eget congue eget, rhoncus vel mauris. Duis nisi magna, aliquet a convallis non, venenatis at nisl. Nunc at quam eu magna malesuada dignissim. Duis bibendum iaculis felis, eu venenatis risus sodales non. In ligula mi, faucibus eu tristique sed, vulputate rutrum dolor.</p>

        <%--<figure>--%>
            <%--<img src="images/sample.png" width="320" height="175" alt="">--%>
        <%--</figure>--%>
        <%--<figure>--%>
            <%--<img src="images/sample.png" width="320" height="175" alt="">--%>
        <%--</figure>--%>

        <h2>OUR TEAM</h2>
        <div class="team-row">
            <figure>
                <img src="images/sample.png" width="96" height="96" alt="">
                <figcaption>John Doe<span>ceo</span></figcaption>
            </figure>
            <figure>
                <img src="images/sample.png" width="96" height="96" alt="">
                <figcaption>Saundra Pittsley<span>team leader</span></figcaption>
            </figure>
            <figure>
                <img src="images/sample.png" width="96" height="96" alt="">
                <figcaption>Julio Simser<span>senior developer</span></figcaption>
            </figure>
            <figure>
                <img src="images/sample.png" width="96" height="96" alt="">
                <figcaption>Margery Venuti<span>senior developer</span></figcaption>
            </figure>
            <figure>
                <img src="images/sample.png" width="96" height="96" alt="">
                <figcaption>Fernando Tondrea<span>developer</span></figcaption>
            </figure>
        </div>
        <div class="team-row">
            <figure>
                <img src="images/sample.png" width="96" height="96" alt="">
                <figcaption>Ericka Nobriga<span>art director</span></figcaption>
            </figure>
            <figure>
                <img src="images/sample.png" width="96" height="96" alt="">
                <figcaption>Cody Rousselle<span>senior ui designer</span></figcaption>
            </figure>
            <figure>
                <img src="images/sample.png" width="96" height="96" alt="">
                <figcaption>Erik Wollman<span>senior ui designer</span></figcaption>
            </figure>
            <figure>
                <img src="images/sample.png" width="96" height="96" alt="">
                <figcaption>Dona Shoff<span>ux designer</span></figcaption>
            </figure>
            <figure>
                <img src="images/sample.png" width="96" height="96" alt="">
                <figcaption>Darryl Brunton<span>ui designer</span></figcaption>
            </figure>
        </div>
    </section>
</div>
<footer>
    <div id="footer">
        <div id="twitter">
            <h3>TWITTER FEED</h3>
            <time datetime="2012-10-23"><a href="#">23 oct</a></time>
            <p>In ultricies pellentesque massa a porta. Aliquam ipsum enim, hendrerit ut porta nec, ullamcorper et nulla. In eget mi dui, sit amet scelerisque nunc. Aenean aug</p>
        </div>
        <div id="sitemap">
            <h3>SITEMAP</h3>
            <div>
                <a href="/home/">Home</a>
                <a href="/about/">About</a>
                <a href="/services/">Services</a>
            </div>
            <div>
                <a href="/partners/">Partners</a>
                <a href="/customers/">Support</a>
                <a href="/contact/">Contact</a>
            </div>
        </div>
        <div id="social">
            <h3>SOCIAL NETWORKS</h3>
            <a href="http://twitter.com/" class="social-icon twitter"></a>
            <a href="http://facebook.com/" class="social-icon facebook"></a>
            <a href="http://plus.google.com/" class="social-icon google-plus"></a>
            <a href="http://vimeo.com/" class="social-icon-small vimeo"></a>
            <a href="http://youtube.com/" class="social-icon-small youtube"></a>
            <a href="http://flickr.com/" class="social-icon-small flickr"></a>
            <a href="http://instagram.com/" class="social-icon-small instagram"></a>
            <a href="/rss/" class="social-icon-small rss"></a>
        </div>
        <div id="footer-logo">
            <a href="/"><img src="images/footer-logo.png" alt="Whitesquare logo"></a>
            <p>Copyright &copy; 2012 Whitesquare. A <a href="http://pcklab.com">pcklab</a> creation </p>
        </div>
    </div>
</footer>
</body>
</html>