<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript">
    function jump(pageNum)  {
        $("#pageNum").val(pageNum);
        document.getElementById("searchForm").submit();
    }
</script>
<div class="panel-heading text-right">
    <c:if test="${pages.hasPreviousPage==true}"><a class="btn btn-default" href="javascript:void(0);" onclick="jump(${pages.pageNum-1});"><上一页</a></c:if>
    <c:if test="${pages.isFirstPage==false}"><a class="btn btn-default" href="javascript:void(0);" onclick="jump(1);">首页</a></c:if>
    <c:if test="${pages.pageNum > 7}"><a class="btn btn-default" href="javascript:void(0);" onclick="jump(${pages.pageNum-6});">...</a></c:if>
    <c:if test="${pages.pageNum > 6}"><a class="btn btn-default" href="javascript:void(0);" onclick="jump(${pages.pageNum-5});">${pages.pageNum-5}</a></c:if>
    <c:if test="${pages.pageNum > 5}"><a class="btn btn-default" href="javascript:void(0);" onclick="jump(${pages.pageNum-4});">${pages.pageNum-4}</a></c:if>
    <c:if test="${pages.pageNum > 4}"><a class="btn btn-default" href="javascript:void(0);" onclick="jump(${pages.pageNum-3});">${pages.pageNum-3}</a></c:if>
    <c:if test="${pages.pageNum > 3}"><a class="btn btn-default" href="javascript:void(0);" onclick="jump(${pages.pageNum-2});">${pages.pageNum-2}</a></c:if>
    <c:if test="${pages.pageNum > 2}"><a class="btn btn-default" href="javascript:void(0);" onclick="jump(${pages.pageNum-1});">${pages.pageNum-1}</a></c:if>
    <a class="btn btn-primary" href="javascript:void(0);" onclick="jump(${pages.pageNum});">${pages.pageNum}</a>
    <c:if test="${pages.pages - pages.pageNum > 1}"><a class="btn btn-default" href="javascript:void(0);" onclick="jump(${pages.pageNum+1});">${pages.pageNum+1}</a></c:if>
    <c:if test="${pages.pages - pages.pageNum > 2}"><a class="btn btn-default" href="javascript:void(0);" onclick="jump(${pages.pageNum+2});">${pages.pageNum+2}</a></c:if>
    <c:if test="${pages.pages - pages.pageNum > 3}"><a class="btn btn-default" href="javascript:void(0);" onclick="jump(${pages.pageNum+3});">${pages.pageNum+3}</a></c:if>
    <c:if test="${pages.pages - pages.pageNum > 4}"><a class="btn btn-default" href="javascript:void(0);" onclick="jump(${pages.pageNum+4});">${pages.pageNum+4}</a></c:if>
    <c:if test="${pages.pages - pages.pageNum > 5}"><a class="btn btn-default" href="javascript:void(0);" onclick="jump(${pages.pageNum+5});">${pages.pageNum+5}</a></c:if>
    <c:if test="${pages.pages - pages.pageNum > 6}"><a class="btn btn-default" href="javascript:void(0);" onclick="jump(${pages.pageNum+6});">...</a></c:if>
    <c:if test="${pages.isLastPage==false}"><a class="btn btn-default" href="javascript:void(0);" onclick="jump(${pages.pages});">末页</a></c:if>
    <c:if test="${pages.hasNextPage==true}"><a class="btn btn-default" href="javascript:void(0);" onclick="jump(${pages.pageNum+1});">下一页></a></c:if>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    当前第【${pages.pageNum}】页&nbsp;&nbsp;&nbsp;
    共【${pages.pages}】页&nbsp;&nbsp;&nbsp;
    共【${pages.total}】条记录

</div>