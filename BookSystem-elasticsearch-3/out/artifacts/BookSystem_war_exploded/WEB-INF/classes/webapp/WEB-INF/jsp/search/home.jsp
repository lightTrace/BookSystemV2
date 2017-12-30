<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="layout/header.jsp" />

<div class="row">
	<div class="span12">
		<c:if test="${not empty message}">
			<div class="alert">${message}</div>
		</c:if>
		<div class="hero-unit">
			<h1>elasticsearch结合spring springmvc jest 使用做成ＷＥＢ架构</h1>
			<br />

			<p>oyhk 学习笔记 上一篇文章,说到了先利用jest junit构架一个ＥＳ的搜索入门例子...现在准备要做一个ES的ＷＥＢ架构例子,希望大家都学习学习ＥＳ分布式搜索引擎,真的非常不错的...欢迎大家一起讨论讨论...

				做成ＷＥＢ的架构,当然我不用servlet了...直接使用spring springmvc去做吧...也当是一个ＥＳ跟spring springmvc 集成的例子,为了简单起见,我这里不用freemarker了..我直接使用jsp做视图...

				当然我也是用maven了...如果不有熟悉maven的朋友们,可以跟我交流下,大家学习学习...</p>
		</div>
	</div>
</div>

<c:import url="layout/footer.jsp" />
