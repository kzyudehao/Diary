<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	
<div class="data_list">
	
	<div class="data_list_title">
		<img
			src="${pageContext.request.contextPath}/images/diary_show_icon.png" />
		日记信息
	</div>

	<div>
		<div class="diary_title">
			<h3>${diary.title }</h3>
		</div>
		<div class="diary_info">
			发布时间：『
			<fmt:formatDate value="${diary.releaseDate }" type="date"
				pattern="yyyy-MM-dd HH:mm:ss" />
			』&nbsp;&nbsp;日志类型：${diary.typeName }
		</div>
		<div class="diary_content">
			${diary.content }
		</div>
		<div class="diary_action">
			<button class="btn btn-primary" type="button" onclick="">修改日志</button>
			<button class="btn btn-primary" type="button" onclick="javascript:history.back()">返回</button>
			<button class="btn btn-danger" type="button" onclick="">删除日志</button>
		</div>
	</div>
</div>



