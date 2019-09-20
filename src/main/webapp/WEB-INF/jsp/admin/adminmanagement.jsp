<%@ page import="cn.tommyyang.workmanagement.utils.Constants" %>
<%--
  Created by IntelliJ IDEA.
  Author: TommyYang
  Date: 2019-09-16
  Time: 15:16
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String webRoot = Constants.WEB_ROOT;%>
<html>
<head>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8" />
        <title>管理员管理页面</title>
        <link href="<%=webRoot%>/jeasyui/themes/icon.css" rel="stylesheet" />
        <link href="<%=webRoot%>/jeasyui/themes/default/easyui.css" rel="stylesheet" />
        <link href="<%=webRoot%>/css/common.css" rel="stylesheet">
        <link rel="stylesheet" href="<%=webRoot%>/css/bootstrap.min.css" />
        <script src="<%=webRoot%>/jeasyui/jquery.min.js"></script>
        <script src="<%=webRoot%>/jeasyui/jquery.easyui.min.js"></script>
        <script src="<%=webRoot%>/jeasyui/locale/easyui-lang-zh_CN.js"></script>
    </head>
</head>
<body>
    <table id="dg">
    </table>
</body>
</html>

<script type="text/javascript">
    $('#dg').datagrid({
        loadMsg : "数据加载中...",
        fit : true,
        singleSelect : true,
        fitColumns : true,
        pagination: true,
        url : '<%=webRoot%>/admin/getdata.do',
        method: 'get',
        onSelect : function() {
            $('#btn_remove').linkbutton('enable');
        },
        onUnselect : function() {
            $('#btn_remove').linkbutton('disable');
        },
        columns : [ [ {
            field : 'id',
            title : '管理员id',
            width : 20,
            hidden: true
        }, {
            field : 'name',
            title : '管理员名称',
            width : 40
        },{
            field : 'account',
            title : '管理员账户',
            width : 80
        },{
            field : 'type',
            title : '管理员类型',
            width : 20
        } ] ],
        toolbar : [ {
            iconCls : 'icon-add',
            id : 'btn-add',
            text : '添加',
            <%--handler : function() {--%>
                <%--window.location.href="<%=webRoot%>/admin/goadd.do";--%>
            <%--}--%>
        }, '-', {
            iconCls : 'icon-remove',
            id : 'btn_remove',
            text : '删除',
            disabled : true,
            handler : function() {
                var row = $('#dg').datagrid('getSelected');
                $.messager.confirm('提示', '您确定要删除吗？', function(r){
                    if (r){
                        $.ajax({
                            url : "<%=webRoot%>/admin/del.do",
                            type : "post",
                            dataType : "json",
                            async : false,
                            //传送请求数据
                            data : {
                                "id" : row.pid,
                                "path" : row.purl
                            },
                            //根据返回值进行状态显示
                            success : function(data) {
                                if (data == "1") {
                                    $.messager.alert('我的消息', '删除成功!', '提示');
                                    $('#dg').datagrid('reload',null);
                                } else {
                                    $.messager.alert('我的消息', '删除失败!', '提示');
                                    $('#dg').datagrid('reload',null);
                                }
                            }
                        });
                    }
                });
            }
        }]
    });
    //分页
    var pagenum = 10;
    load();
    function load() {
        var p = $('#dg').datagrid('getPager');
        $(p).pagination({
            pageSize: pagenum, //每页显示的记录条数，默认为10
            pageList: [10, 20, 30], //可以设置每页记录条数的列表
            beforePageText: '第', //页数文本框前显示的汉字
            afterPageText: '页    共 {pages} 页',
            displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
            onBeforeRefresh: function(pageNumberNow, pageSizeNow) {
                pagenum = pageSizeNow;
                $('#dg').datagrid('reload',null);
                load();
            }
        });
    }
</script>
