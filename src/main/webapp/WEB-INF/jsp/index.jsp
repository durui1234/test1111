<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
</head>

<body style="width:900px; margin:0px auto;" onload="chanclo()">
<div style="width:900px; text-align:center">
    <h2>图书信息列表</h2>
</div>
<div style="width:880px; text-align:right; padding-right:20px; line-height:25px; height:25px;"><a href="#">添加图书信息</a></div>
<div style="width:900px; text-align:center">
    <form id="Form" action="${pageContext.request.contextPath}/index" method="post">
        上传类型：
        <select name="typeid" id="typeid">
            <option value="-1">-请选择--</option>
            <c:if test="${requestScope.list!=null}">
                <c:forEach items="${requestScope.list}" var="type">
                    <option value="${type.id}" <c:if test="${type.id==requestScope.param.typeid}">selected="selected"</c:if>>${type.name}</option>
                </c:forEach>
            </c:if>
        </select>
        上传时间：
        <input name="min_billtime" type="date" id="min_billtime" size="10"
               value="<fmt:formatDate value="${requestScope.param.min_billtime}" pattern="yyyy-MM-dd"></fmt:formatDate>"/>
        到
        <input name="max_billtime" type="date" id="max_billtime" size="10"
               value="<fmt:formatDate value="${requestScope.param.max_billtime}" pattern="yyyy-MM-dd"></fmt:formatDate>"/>
        <input type="hidden" name="pageIndex" id="pageIndex" value="1" />
        <input type="submit" name="btnSearch" id="btnSearch" value="查询图书" />
    </form>




</div>
<div style="width:900px; text-align:center">
    <table width="900" border="1" cellspacing="0" cellpadding="0">
        <tr>
            <td>标题</td>
            <td>记账时间</td>
            <td>类别</td>
            <td>金额</td>
            <td>说明</td>
            <td>详细</td>
            <td>删除</td>
            <td>修改</td>
        </tr>
        <c:if test="${page.list!=null}">
            <c:forEach items="${page.list}" var="pa">
                <tr>
                    <td>${pa.title}</td>
                    <td><fmt:formatDate value="${pa.billtime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                    <td>${pa.billType.name}</td>
                    <td>${pa.price}</td>
                    <td>${pa.explains}</td>
                    <td><a href="${pageContext.request.contextPath}/get/${pa.id}">详细</a></td>
                    <td><a href="javascript:do_delete(${pa.id})">删除</a></td>
                    <td><a href="${pageContext.request.contextPath}/update/${pa.id}">修改</a></td>
                </tr>
            </c:forEach>
        </c:if>


        <tr>
            <td colspan="9" align="center" valign="middle">
                <a href="javascript:do_page(1)">首页</a>&nbsp;&nbsp;
                <a href="javascript:do_page(${page.pageNum-1})">上一页</a>&nbsp;&nbsp;
                <a href="javascript:do_page(${page.pageNum+1})"> 下一页</a>&nbsp;&nbsp;
                <a href="javascript:do_page(${page.pages})"> 末页</a>&nbsp;&nbsp;
                ${page.pageNum}/${page.pages}页
            </td>
        </tr>
    </table>
</div>
</body>
<script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
<script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
<script type="application/javascript" >
    function do_delete(id) {
        if (confirm("确认删除吗?")){
            location.href="${pageContext.request.contextPath}/delete/"+id;
        }
    }
    function do_page(pn) {
        $("#pageIndex").val(pn);
        $("#Form").submit();
    }
    function chanclo() {
//获取标签
        var arr = document.getElementsByTagName("tr");
//for循环实现换色
        for (i = 1; i< arr.length ; i++) {
//如果行数为偶数，背景颜色变为X色
            if (i % 2 == 0) {
                arr[i].style.backgroundColor = "ComflowerBlue";
            }
//如果行数为奇数，背景颜色变为Y色
            else {
                arr[i].style.backgroundColor = "LightSlateGray";
            }
        }}
</script>
</html>