<%@ page import="cn.tommyyang.workmanagement.utils.Constants" %>
<%--
  Created by IntelliJ IDEA.
  Author: TommyYang
  Date: 2019-09-16
  Time: 17:38
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String webRoot = Constants.WEB_ROOT;%>
<html>
<head>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8"/>
        <title>项目管理页面</title>
        <link href="<%=webRoot%>/jeasyui/themes/icon.css" rel="stylesheet"/>
        <link href="<%=webRoot%>/jeasyui/themes/default/easyui.css" rel="stylesheet"/>
        <link href="<%=webRoot%>/css/common.css" rel="stylesheet">
        <link rel="stylesheet" href="<%=webRoot%>/css/bootstrap.min.css"/>
        <script src="<%=webRoot%>/jeasyui/jquery.min.js"></script>
        <script src="<%=webRoot%>/jeasyui/jquery.easyui.min.js"></script>
        <script src="<%=webRoot%>/jeasyui/locale/easyui-lang-zh_CN.js"></script>
    </head>
</head>
<body>

<!-- 数据表 -->
<table id="dg">
</table>
<!-- /数据表 -->
<!-- 数据表工具栏 -->
<div class="toolbar" id="tb">
    <div class="search-div">
        <label>国籍：</label>
        <select id="nationality" class="easyui-combobox">
            <option value="all">ALL</option>
            <option value="阿尔及利亚">阿尔及利亚</option>
            <option value="阿富汗">阿富汗</option>
            <option value="阿根廷">阿根廷</option>
            <option value="阿联酋">阿联酋</option>
            <option value="阿曼">阿曼</option>
            <option value="阿塞拜疆">阿塞拜疆</option>
            <option value="埃及">埃及</option>
            <option value="埃塞俄比亚">埃塞俄比亚</option>
            <option value="爱尔兰">爱尔兰</option>
            <option value="安哥拉">安哥拉</option>
            <option value="奥地利">奥地利</option>
            <option value="澳大利亚">澳大利亚</option>
            <option value="巴布亚新几内亚">巴布亚新几内亚</option>
            <option value="巴基斯坦">巴基斯坦</option>
            <option value="巴林">巴林</option>
            <option value="巴西">巴西</option>
            <option value="白俄罗斯">白俄罗斯</option>
            <option value="保加利亚">保加利亚</option>
            <option value="贝宁">贝宁</option>
            <option value="比利时">比利时</option>
            <option value="冰岛">冰岛</option>
            <option value="波黑">波黑</option>
            <option value="波兰">波兰</option>
            <option value="博茨瓦纳">博茨瓦纳</option>
            <option value="朝鲜">朝鲜</option>
            <option value="赤道几内亚">赤道几内亚</option>
            <option value="大溪地">大溪地</option>
            <option value="丹麦">丹麦</option>
            <option value="德国">德国</option>
            <option value="多哥">多哥</option>
            <option value="俄罗斯">俄罗斯</option>
            <option value="厄瓜多尔">厄瓜多尔</option>
            <option value="厄立特里亚">厄立特里亚</option>
            <option value="法国">法国</option>
            <option value="菲律宾">菲律宾</option>
            <option value="斐济">斐济</option>
            <option value="芬兰">芬兰</option>
            <option value="佛得角">佛得角</option>
            <option value="刚果(布)">刚果(布)</option>
            <option value="刚果(金)">刚果(金)</option>
            <option value="高棉">高棉</option>
            <option value="古巴">古巴</option>
            <option value="圭亚那">圭亚那</option>
            <option value="哈萨克斯坦">哈萨克斯坦</option>
            <option value="韩国">韩国</option>
            <option value="荷兰">荷兰</option>
            <option value="吉尔吉斯斯坦">吉尔吉斯斯坦</option>
            <option value="几内亚">几内亚</option>
            <option value="加拿大">加拿大</option>
            <option value="加纳">加纳</option>
            <option value="柬埔寨">柬埔寨</option>
            <option value="捷克">捷克</option>
            <option value="津巴布韦">津巴布韦</option>
            <option value="喀麦隆">喀麦隆</option>
            <option value="卡塔尔">卡塔尔</option>
            <option value="科威特">科威特</option>
            <option value="肯尼亚">肯尼亚</option>
            <option value="老挝">老挝</option>
            <option value="黎巴嫩">黎巴嫩</option>
            <option value="立陶宛">立陶宛</option>
            <option value="利比亚">利比亚</option>
            <option value="罗马尼亚">罗马尼亚</option>
            <option value="马达加斯加">马达加斯加</option>
            <option value="马来西亚">马来西亚</option>
            <option value="马里">马里</option>
            <option value="马其顿">马其顿</option>
            <option value="毛里求斯">毛里求斯</option>
            <option value="毛里塔尼亚">毛里塔尼亚</option>
            <option value="美国">美国</option>
            <option value="蒙古">蒙古</option>
            <option value="孟加拉国">孟加拉国</option>
            <option value="秘鲁">秘鲁</option>
            <option value="缅甸">缅甸</option>
            <option value="摩洛哥">摩洛哥</option>
            <option value="摩洛哥公国">摩洛哥公国</option>
            <option value="莫桑比克">莫桑比克</option>
            <option value="墨西哥">墨西哥</option>
            <option value="纳米比亚">纳米比亚</option>
            <option value="南非">南非</option>
            <option value="尼泊尔">尼泊尔</option>
            <option value="尼日利亚">尼日利亚</option>
            <option value="葡萄牙">葡萄牙</option>
            <option value="日本">日本</option>
            <option value="瑞典">瑞典</option>
            <option value="瑞士">瑞士</option>
            <option value="沙特阿拉伯">沙特阿拉伯</option>
            <option value="斯里兰卡">斯里兰卡</option>
            <option value="斯洛伐克">斯洛伐克</option>
            <option value="苏丹">苏丹</option>
            <option value="塔吉克斯坦">塔吉克斯坦</option>
            <option value="泰国">泰国</option>
            <option value="坦桑尼亚">坦桑尼亚</option>
            <option value="突尼斯">突尼斯</option>
            <option value="土耳其">土耳其</option>
            <option value="土库曼斯坦">土库曼斯坦</option>
            <option value="委内瑞拉">委内瑞拉</option>
            <option value="文莱">文莱</option>
            <option value="乌干达">乌干达</option>
            <option value="乌克兰">乌克兰</option>
            <option value="乌拉圭">乌拉圭</option>
            <option value="乌兹别克斯坦">乌兹别克斯坦</option>
            <option value="西班牙">西班牙</option>
            <option value="希腊">希腊</option>
            <option value="新加坡">新加坡</option>
            <option value="新西兰">新西兰</option>
            <option value="匈牙利">匈牙利</option>
            <option value="叙利亚">叙利亚</option>
            <option value="牙买加">牙买加</option>
            <option value="亚美尼亚">亚美尼亚</option>
            <option value="也门">也门</option>
            <option value="伊拉克">伊拉克</option>
            <option value="伊朗">伊朗</option>
            <option value="以色列">以色列</option>
            <option value="意大利">意大利</option>
            <option value="印度">印度</option>
            <option value="印尼">印尼</option>
            <option value="英国">英国</option>
            <option value="约旦">约旦</option>
            <option value="越南">越南</option>
            <option value="赞比亚">赞比亚</option>
            <option value="中国">中国</option>
            <option value="中国澳门">中国澳门</option>
            <option value="中国台湾">中国台湾</option>
            <option value="中国香港">中国香港</option>
        </select>

        <label>性别：</label>
        <select id="sex" class="easyui-combobox">
            <option value="all">ALL</option>
            <option value="男">男</option>
            <option value="女">女</option>
        </select>

        <label>赛区：</label>
        <input type="text" class="easyui-textbox" id="division"/>

        <label>组别：</label>
        <input type="text" class="easyui-textbox" id="group"/>

        <button class="easyui-linkbutton" iconCls="icon-search" id="search">搜索</button>
    </div>
    <div class="ctrl-div">
        <a href="#" id="btn_add" class="easyui-linkbutton" iconCls="icon-add" plain="true">新增</a>
        <a href="#" id="btn_remove" class="easyui-linkbutton" iconCls="icon-remove" disabled="true" plain="true">删除</a>
        <a href="#" id="btn_export" class="easyui-linkbutton" iconCls="icon-print" plain="true">导出</a>
    </div>
</div>
<!-- /数据表工具栏 -->


</body>
</html>

<script type="text/javascript">

    $('#dg').datagrid({
        loadMsg: "数据加载中...",
        fit: true,
        singleSelect: true,
        fitColumns: true,
        pagination: true,
        pageSize: 2,
        pageNumber: 1,
        pageList: [2, 5, 10],
        url: '<%=webRoot%>/competition/getdata.do',
        method: 'post',
        queryParams: {
            nationality: "all", sex: "all",
            division: "", group: ""
        },
        onSelect: function () {
            $('#btn_remove').linkbutton('enable');
        },
        onUnselect: function () {
            $('#btn_remove').linkbutton('disable');
        },
        columns: [[{
            field: 'id',
            title: 'id',
            width: 5,
            hidden: true
        }, {
            field: 'name',
            title: '名称',
            width: 10
        }, {
            field: 'birth',
            title: '生日',
            width: 20
        }, {
            field: 'headimg',
            title: '头像',
            width: 20
        }, {
            field: 'nationality',
            title: '国籍',
            width: 10
        }, {
            field: 'sex',
            title: '性别',
            width: 10
        }, {
            field: 'level',
            title: '水平',
            width: 10
        }, {
            field: 'project',
            title: '项目名称',
            width: 20
        }, {
            field: 'musicurl',
            title: '音乐作品',
            width: 20
        }, {
            field: 'division',
            title: '赛区',
            width: 10
        }, {
            field: 'group',
            title: '项目分组',
            width: 20
        }, {
            field: 'instrument',
            title: '项目乐器',
            width: 15
        }, {
            field: 'address',
            title: '地址',
            width: 15
        }, {
            field: 'phone',
            title: '手机号码',
            width: 10
        }, {
            field: 'teacher',
            title: '指导老师',
            width: 10
        }, {
            field: 'mobile',
            title: '老师电话',
            width: 10
        }, {
            field: 'type',
            title: '项目类型',
            width: 15
        }, {
            field: 'orderno',
            title: '订单号',
            width: 20
        }, {
            field: 'pid',
            title: '报名人数',
            width: 15
        }, {
            field: 'orderamount',
            title: '订单金额',
            width: 15
        }, {
            field: 'paystatus',
            title: '支付状态',
            width: 15
        }, {
            field: 'createtime',
            title: '创建时间',
            width: 15
        }]],
        toolbar: '#tb'
    });

    $('#search').click(function () {
        var nationality = $('#nationality').combobox('getValue');
        var sex = $('#sex').combobox('getValue');
        var division = $('#division').val();
        var group = $('#group').val();
        if (division == null) {
            division = "";
        }
        if (group == null) {
            group = "";
        }

        reloadgrid(nationality, sex, division, group);
    });

    function reloadgrid(nationality, sex, division, group) {
        // 查询参数直接添加在url中
        var url = "<%=webRoot%>/competition/getdata.do";
        $('#dg').datagrid('options').url = url;
        // 查询参数直接添加在queryParams中
        var queryParams = $('#dg').datagrid('options').queryParams;
        queryParams.nationality = nationality;
        queryParams.sex = sex;
        queryParams.division = division;
        queryParams.group = group;
        $('#dg').datagrid('options').queryParams = queryParams;
        $("#dg").datagrid('reload', null);
    }


    $('#btn_remove').click(function () {
        var row = $('#dg').datagrid('getSelected');
        $.messager.confirm('提示', '您确定要删除吗？', function (r) {
            if (r) {
                $.ajax({
                    url: "<%=webRoot%>/competition/del.do",
                    type: "post",
                    dataType: "json",
                    async: false,
                    //传送请求数据
                    data: {
                        "id": row.id,
                        "path": row.url
                    },
                    //根据返回值进行状态显示
                    success: function (data) {
                        if (data == "1") {
                            $.messager.alert('我的消息', '删除成功!', '提示');
                            $('#dg').datagrid('reload', null);
                        } else {
                            $.messager.alert('我的消息', '删除失败!', '提示');
                            $('#dg').datagrid('reload', null);
                        }
                    }
                });

            }
        });

    });

    $('#btn_export').click(function () {
        var nationality = $('#nationality').combobox('getValue');
        var sex = $('#sex').combobox('getValue');
        var division = $('#division').val();
        var group = $('#group').val();
        if (division == null) {
            division = "";
        }
        if (group == null) {
            group = "";
        }

        var url = "<%=webRoot%>/competition/export.do";
        var form = $("<form></form>").attr("action", url).attr("method", "post");
        form.append($("<input />").attr("type", "hidden").attr("name", "nationality").attr("value", nationality))
            .append($("<input />").attr("type", "hidden").attr("name", "sex").attr("value", sex))
            .append($("<input />").attr("type", "hidden").attr("name", "division").attr("value", division))
            .append($("<input />").attr("type", "hidden").attr("name", "group").attr("value", group));
        form.appendTo('body').submit().remove();
        <%--$.ajax({--%>
            <%--url: "<%=webRoot%>/competition/export.do",--%>
            <%--type: "post",--%>
            <%--//传送请求数据--%>
            <%--data: {--%>
                <%--"nationality": nationality,--%>
                <%--"sex": sex,--%>
                <%--"division": division,--%>
                <%--"group": group--%>
            <%--}--%>
        <%--});--%>
    });

</script>
