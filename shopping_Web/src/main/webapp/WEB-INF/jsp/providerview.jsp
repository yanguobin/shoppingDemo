<%--
  Created by IntelliJ IDEA.
  User: yanguobin
  Date: 2018/12/28
  Time: 12:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>供应商管理页面 >> 信息查看</span>
    </div>
    <div class="providerView">
        <p><strong>供应商编码：</strong><span>${provider.proCode }</span></p>
        <p><strong>供应商名称：</strong><span>${provider.proName }</span></p>
        <p><strong>联系人：</strong><span>${provider.proContact }</span></p>
        <p><strong>联系电话：</strong><span>${provider.proPhone }</span></p>
        <p><strong>传真：</strong><span>${provider.proFax }</span></p>
        <p><strong>描述：</strong><span>${provider.proDesc}</span></p>
        <p><strong>企业营业执照：</strong><span>
            <c:choose>
                <c:when test="${provider.companyLicPicPath == null || provider.companyLicPicPath == ''}">
                    暂无
                </c:when>
                <c:otherwise>
                    <img src="${provider.companyLicPicPath}"/>
                </c:otherwise>
            </c:choose>
            </span></p>

        <p><strong>组织机构代码证：</strong><span>
            <c:choose>
                <c:when test="${provider.orgCodePicPath == null || provider.orgCodePicPath == ''}">
                    暂无
                </c:when>
                <c:otherwise>
                    <img src="${provider.orgCodePicPath}"/>
                </c:otherwise>
            </c:choose>
            </span></p>

        <div class="providerAddBtn">
            <input type="button" id="back" name="back" value="返回" >
        </div>
    </div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="/statics/js/providerview.js"></script>

