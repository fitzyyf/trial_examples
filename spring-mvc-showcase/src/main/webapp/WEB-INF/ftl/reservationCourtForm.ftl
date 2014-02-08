<#import '/spring.ftl' as s/>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]/>
<html>
<head>
    <title>第一步预订</title>
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
        <td>球场名称</td>
        <td><@form.input path="courtName" /></td>
        <td><@form.errors path="courtName" cssClass="error" /></td>
    </tr>
    <tr>
        <td colspan="3">
			<#--记录用户所在页面，这里为0-->
            <input type="hidden" value="0" name="_page"/>
			<#--转到目标页面,1 表示页面索引，这里表示第一个-->
            <input type="submit" value="下一步" name="_target1" />
			<#--特殊请求参数 _cancel 表示取消向导表单-->
            <input type="submit" value="Cancel" name="_cancel" />
        </td>
    </tr>
</table>
</@form.form>
</body>

</html>