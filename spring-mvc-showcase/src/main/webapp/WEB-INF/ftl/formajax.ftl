<#import '/spring.ftl' as s/>
<!DOCTYPE html>
<html>
<head>
    <title>Ajax 上传</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet" type="text/css">
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css">

</head>
<body>
<div class="row">
    <div class="span2"></div>
    <div class="span10">

        <form id="ajaxUploadForm" method="post" class="form-horizontal">
            <fieldset>
                <legend>
                    文件上传
                </legend>
                <div class="control-group">
                    <label class="control-label" for="inputUserName">名称</label>

                    <div class="controls">
                        <input id="inputUserName" type="text" name="username">
                    </div>
                </div>

                <div class="control-group">
                    <label class="control-label" for="inputFile">文件</label>

                    <div class="controls">
                        <input id="inputFile" type="file" name="file1">
                    </div>
                </div>

                <div class="control-group">
                    <div class="controls">
                        <button type="submit" class="btn">提交</button>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</div>


<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>

<script type="text/javascript">

    $('#ajaxUploadForm').submit(function () {
        var formdata = new FormData(this);
        $.ajax({
            type       : 'post',
            url        : '<@s.url '/upload'/>',
            data       : formdata,
            /**
             *必须false才会自动加上正确的Content-Type
             */
            contentType: false,
            /**
             * 必须false才会避开jQuery对 formdata 的默认处理
             * XMLHttpRequest会对 formdata 进行正确的处理
             */
            processData: false
        }).then(function () {
                    //doneCal
                }, function () {
                    //failCal
                });
        return false;
    });
</script>

</body>

</html>