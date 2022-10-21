/**
 *
 */

// var item = function(view.itemImg){
//   this.view.itemImg = view.itemImg;
// }

// var itemImg = ${view.itemImg};
// var list = '<c:out value="${view}"/>';

var list = new Array();

var keep = `<img style="width: 300px; height: 300px;" alt="img_area"
		 src="<c:url value='/resources/upload_img/${view.itemImg}'/>">
		 <input name="itemImg" value="${view.itemImg}">`;

var change = `<label id="imgChange">상품 이미지</label>
		 <input type="file" name="imgUpload">`;

$(function(){
  $("imgBtn").on("click",function(){
    $("imgLi").append(keep);
  });
});
