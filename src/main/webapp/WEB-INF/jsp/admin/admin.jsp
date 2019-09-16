<%@ page import="cn.tommyyang.workmanagement.utils.Constants" %>
<%--
  Created by IntelliJ IDEA.
  Author: TommyYang
  Date: 2019-09-11
  Time: 18:45
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String webRoot = Constants.WEB_ROOT;%>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8" />
    <title>管理中心</title>
    <link href="<%=webRoot%>/jeasyui/themes/icon.css" rel="stylesheet" />
    <link href="<%=webRoot%>/jeasyui/themes/default/easyui.css" rel="stylesheet" />
    <link href="<%=webRoot%>/css/common.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=webRoot%>/css/bootstrap.min.css" />
    <script src="<%=webRoot%>/jeasyui/jquery.min.js"></script>
    <script src="<%=webRoot%>/jeasyui/jquery.easyui.min.js"></script>
    <script src="<%=webRoot%>/jeasyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body class="easyui-layout" id="layout" style="visibility:hidden;">

<div region="north" id="header">
    <img src="<%=webRoot%>/img/logo.png" class="logo" />
    <div class="top-btns">
        <span>欢迎您，管理员: ${sessionScope.get("admin")}</span>
        <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-lock'">修改密码</a>
        <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-clear'">退出系统</a>
        <select class="easyui-combobox" data-options="editable:false">
            <option value="0" selected="selected">中文</option>
            <option value="1">English</option>
        </select>
    </div>
</div>

<div region="west" split="true" title="导航菜单" id="naver">
    <div class="easyui-accordion" fit="true" id="navmenu">
        <div title="人员管理">
            <ul class="navmenu">
                <li class="active"><a href="#">首页</a></li>
                <li><a href="#" onclick="addTab('管理员管理','<%=webRoot%>/admin/manage.do', 'icon-user')">管理员人员管理</a></li>
            </ul>
        </div>
        <div title="绩效考核"></div>
        <div title="报表管理"></div>
        <div title="系统管理"></div>
        <div title="组件示例">
            <ul class="navmenu">
                <li><a href="#" data-url="html/demo01.html">锁定行和列</a></li>
            </ul>
        </div>
    </div>
</div>

<div region="center" id="content">
    <div class="easyui-tabs" fit="true" id="tt">

        <div title="首页" iconCls="icon-ok">
            <div class="easyui-accordion" data-options="fit:true">
                <div title="待办事项">
                    <div class="flow-panel">
                        <div class="flow-todo">
                            <ul class="todo-list">
                                <li>
                                    <span>代办事项 A</span>
                                    <a href="#" class="num">5</a>
                                </li>
                                <li>
                                    <span>代办事项 B</span>
                                    <a href="#" class="num">5</a>
                                </li>
                                <li>
                                    <span>代办事项 C</span>
                                    <a href="#" class="num">5</a>
                                </li>
                                <li>
                                    <span>代办事项 D</span>
                                    <a href="#" class="num">5</a>
                                </li>
                                <li>
                                    <span>代办事项 E</span>
                                    <a href="#" class="num">5</a>
                                </li>
                                <li>
                                    <span>代办事项 F</span>
                                    <a href="#" class="num">5</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div title="系统公告">
                    <ul class="notice-list">
                        <li>
                            <span>这是一条系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告</span>
                            <span class="date">2015-10-30</span>
                        </li>
                        <li>
                            <span>这是一条系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告</span>
                            <span class="date">2015-10-30</span>
                        </li>
                        <li>
                            <span>这是一条很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长的系统公告</span>
                            <span class="date">2015-10-30</span>
                        </li>
                        <li>
                            <span>这是一条系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告</span>
                            <span class="date">2015-10-30</span>
                        </li>
                        <li>
                            <span>这是一条系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告</span>
                            <span class="date">2015-10-30</span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

    </div>
</div>

<div region="south" id="footer">某某后台管理系统 V1.0</div>

<script type="text/javascript">
    $(function() {
        //添加新的Tab页
        $("#navmenu").on("click", "a[data-url]", function(e) {
            e.preventDefault();
            var tabTitle = $(this).text();
            var tabUrl = $(this).data("url");

            if($("#tt").tabs("exists", tabTitle)) { //判断该Tab页是否已经存在
                $("#tt").tabs("select", tabTitle);
            }else {
                $("#tt").tabs("add", {
                    title: tabTitle,
                    href: tabUrl,
                    closable: true
                });
            }
            $("#navmenu .active").removeClass("active");
            $(this).parent().addClass("active");
        });

        //解决闪屏的问题
        window.setTimeout(function() {
            $("#layout").css("visibility", "visible");
        }, 800);
    });

    function addTab(title, url, img) {
        if ($('#tt').tabs('exists', title)) {
            $('#tt').tabs('select', title);
        } else {
            var content = '<iframe scrolling="auto" frameborder="0"  src="'
                + url + '"  style="width:100%;height:100%;"></iframe>';
            $('#tt').tabs('add', {
                title : title,
                content : content,
                closable : true,
                iconCls : img
            });
        }
    }

</script>
</body>
</html>
