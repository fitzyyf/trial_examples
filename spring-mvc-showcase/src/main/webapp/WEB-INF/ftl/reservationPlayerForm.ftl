<#import '/spring.ftl' as s/>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]/>
<html>
<head>
    <title>第三步预订</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style type="text/css">
        .error{
            color:#ff0000;
            font-weight:bold;
        }
    </style>
</head>
<body>
<@form.form method="post" commandName="reservation">
    <table>
        <tr>
            <td>玩家姓名</td>
            <td><@form.input path="player.name" /></td>
            <td><@form.errors path="player.name" cssClass="error" /></td>
        </tr>
        <tr>
            <td>联系号码</td>
            <td><@form.input path="player.phone" /></td>
            <td><@form.errors path="player.phone" cssClass="error" /></td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="hidden" value="2" name="_page"/>
                <input type="submit" value="上一步" name="_target1" />
				<#--要求结束这个表单，_finish 必须为这个值-->
                <input type="submit" value="完成预订" name="_finish" />
                <input type="submit" value="取消" name="_cancel" />
            </td>
        </tr>
    </table>
</@form.form>
</body>
</html>