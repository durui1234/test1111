<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="margin:0 auto; width:800px">
<div style="text-align:center; width:800px">
    <h2>记账详细</h2>
</div>
<div style="text-align:center; width:800px">
    <form action="${pageContext.request.contextPath}/index" method="post">
        <table width="100%" border="1" cellpadding="0" cellspacing="0">
            <tr>
                <td>账单</td>
                <td>${bill.id}</td>
            </tr>
            <tr>
                <td width="13%">类型</td>
                <td width="87%">
                    ${bill.billType.name}
                </td>
            </tr>
            <tr>
                <td>标题</td>
                <td>
                    ${bill.title}
            </tr>
            <tr>
                <td>日期</td>
                <td>
                    <fmt:formatDate value="${bill.billtime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
            </tr>
            <tr>
                <td>金额</td>
                <td>${bill.price}</td>
            </tr>
            <tr>
                <td>说明</td>
                <td>${bill.explains}</td>
            </tr>
            <tr>
                <td colspan="2" align="center" valign="middle"><input type="submit" name="sub" id="sub" value="返回" />&nbsp;&nbsp;&nbsp;
            </tr>
        </table>
    </form>
</div>
</body>
</html>
