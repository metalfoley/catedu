<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">Modal Example 1</h4>
          </div>
          <div class="modal-body">
            <form class="container">
              <div class="row">
                <Label for="name">Example 1: </label>
                <input type="text" name="name">
                <Label for="name2">Example 2: </label>
                <input type="text" name="name2">
              </div>
              <div class="row">
                <Label for="name3">Example 3: </label>
                <input type="text" name="nam3e">
                <Label for="name4">Example 4: </label>
                <input type="text" name="name4">
              </div>
              <div class="row">
                <Label for="name5">Example 5: </label>
                <input type="text" name="name5">
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <p class="pull-left" id="modalError">Error</p>
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary">Save changes</button>
          </div>
        </div>
      </div>
    </div>