<#import '/spring.ftl' as s/>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]/>
<html>
<head>
    <title>第二步预订</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style type="text/css">
        .error{
            color:#ff0000;
            font-weight:bold;
        }
    </style>
</head>
<body>
<@form.form method="post" modelAttribute="reservation">
    <table>
        <tr>
            <td>开始时间</td>
            <td><@form.input path="fromDate" /></td>
            <td><@form.errors path="fromDate" cssClass="error" /></td>
        </tr>
        <tr>
            <td>到期使用时间</td>
            <td><@form.input path="toDate" /></td>
            <td><@form.errors path="toDate" cssClass="error" /></td>
        </tr>
        <#--<tr>-->
            <#--<td>使用周期</td>-->
            <#--<td><@form.select path="period" items="${periods}" /></td>-->
            <#--<td><@form.errors path="period" cssClass="error" /></td>-->
        <#--</tr>-->
        <tr>
            <td>使用时间</td>
            <td><@form.input path="hour" /></td>
            <td><@form.errors path="hour" cssClass="error" /></td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="hidden" value="1" name="_page"/>
                <input type="submit" value="上一步" name="_target0" />
                <input type="submit" value="下一步" name="_target2" />
                <input type="submit" value="取消" name="_cancel" />
            </td>
        </tr>
    </table>
</@form.form>
</body>
</html>