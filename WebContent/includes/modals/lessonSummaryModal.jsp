<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Modal -->
<div class="modal fade" id="lessonSummaryModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog lessonModal" role="document">
    <div class="modal-content">
      <div class="modal-header lessonModalHead clearfix">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <div class="pull-left col-md-7">
	        <h4 class="modal-title" id="myModalLabel">${lesson.getName()}</h4>
	        <p>${lesson.getShortDescription() }</p>
        </div>
        <div class="pull-right col-md-5">
        	<p>${lesson.getAuthor().getFirstName()} ${lesson.getAuthor().getLastName()}   ${lesson.getLeadLesson()}   </p>
        </div>
      </div>
      <div class="modal-body">
        <p><span class="modalLead">Full Description:</span> ${lesson.getFullDescription()}</p>
        <p><span class="modalLead">Enhancements:</span> ${lesson.getEnhancements() }</p>
        <p><span class="modalLead">Extensions:</span> ${lesson.getExtensions() }</p>
        <p><span class="modalLead">Details:</span> ${lesson.getDetails() }</p>
        <p><span class="modalLead">Materials:</span> ${lesson.getMaterials() }</p>
        <p><span class="modalLead">Core Standards:</span> </p>
        <c:forEach var="coreClass" items="${lesson.getClassCoreLink()}">
        	<ul>
        		<li>${coreClass.key}</li>
        		<ul>
	        		<c:forEach var="coreClassValue" items="${coreClass.value}">
	        		<li>${coreClassValue}</li>
	        		</c:forEach>
        		</ul>
        	</ul>
        	
        </c:forEach>
        <p><span class="modalLead">Assessment Type:</span> ${lesson.getAssessType() }</p>
        <p><span class="modalLead">Assessment Link:</span> ${lesson.getAssessLink() }</p>
        <p><span class="modalLead">Assessment Info:</span> ${lesson.getAssessInfo() }</p>
      </div>
      <div class="modal-footer">
      	<button type="button" class="btn btn-primary">Print</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>