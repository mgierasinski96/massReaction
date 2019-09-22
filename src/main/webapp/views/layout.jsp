<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true" /></title>

    <style>

        *
        {
            margin:0;
            padding:0;
        }
#naglowek
{
    position: absolute;
    height: 100px;
    width: 100%;
    top: 0;
    background-color: red;
}
#tresc
{
    position: absolute;
    height: 600px;
    width: 100%;
    top: 100px;
    background-color: blue;
}



#content
{
    height: 100%;
    width: 100%;
    position: relative;
}


    </style>
</head>
<body>

<div id="content">
    <div id="naglowek"><tiles:insertAttribute name="header" /></div>
    <div id="tresc"><tiles:insertAttribute name="body" /></div>
</div>

</body>
</html>
