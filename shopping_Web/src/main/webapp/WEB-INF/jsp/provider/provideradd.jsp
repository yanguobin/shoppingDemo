<%--
  Created by IntelliJ IDEA.
  User: yanguobin
  Date: 2018/12/28
  Time: 12:06 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link type="text/css" rel="stylesheet" href="/statics/css/style.css" />
    <link type="text/css" rel="stylesheet" href="/statics/css/public.css" />
</head>
<body>

<div class="right" style="background: #FFFFFF;">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>供应商管理页面 >> 供应商添加页面</span>
    </div>
    <div class="providerAdd">
        <fm:form method="post" modelAttribute="provider">
            <div>
                <label for="proCode">供应商编码：</label>
                <fm:input path="proCode"/>
                <fm:errors path="proCode" style="color:red"/>
            </div>
            <div>
                <label for="proName">供应商名称：</label>
                <fm:input path="proName"/>
                <fm:errors path="proName"  style="color:red"/>
            </div>
            <div>
                <label for="proContact">联系人：</label>
                <fm:input path="proContact"/>
                <fm:errors path="proContact"  style="color:red"/>

            </div>
            <div>
                <label for="proPhone">联系电话：</label>
                <fm:input path="proPhone"/>
                <fm:errors path="proPhone"  style="color:red"/>
            </div>
            <div>
                <label for="proAddress">联系地址：</label>
                <fm:input path="proAddress" />
            </div>
            <div>
                <label for="proFax">传真：</label>
                <fm:input path="proFax"/>
            </div>
            <div>
                <label for="proDesc">描述：</label>
                <fm:input path="proDesc"/>
            </div>
            <div class="providerAddBtn">
                <input type="submit" value="保存">
                <input type="button" id="back" name="back" value="返回" >
            </div>
        </fm:form>
    </div>
</div>
<script type="text/javascript" src="/statics/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/statics/js/common.js"></script>
</body>
</html>