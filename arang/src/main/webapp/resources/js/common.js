
// 이미지 틀에 맞추기
function artwork_large(imgFile) {
  var imgWidth = imgFile.width;
  var imgHeight = imgFile.height;
  console.log(imgWidth);
  console.log(imgHeight);
  var maxImgWidth = 600;
  var maxImgHeight = 600;

  if (imgWidth > maxImgWidth || imgHeight > maxImgHeight) {
    imgFile.style.maxWidth="600px";
    imgFile.style.maxHeight="600px";
  }
  else if (imgWidth < maxImgWidth || imgHeight < maxImgHeight) {
    imgFile.style.minWidth="600px";
    imgFile.style.minHeight="600px";
  }
}


function artwork_middle(imgFile) {
  var imgWidth = imgFile.width;
  var imgHeight = imgFile.height;
  console.log(imgWidth);
  console.log(imgHeight);
  var maxImgWidth = 255;
  var maxImgHeight = 255;

  if (imgWidth > maxImgWidth || imgHeight > maxImgHeight) {
    imgFile.style.maxWidth="255px";
    imgFile.style.maxHeight="255px";
  }
  else if (imgWidth < maxImgWidth || imgHeight < maxImgHeight) {
    imgFile.style.minWidth="255px";
    imgFile.style.minHeight="255px";
  }
}

function artwork_small_middle(imgFile) {
	console.log("test");
  var imgWidth = imgFile.width;
  var imgHeight = imgFile.height;
  console.log(imgWidth);
  console.log(imgHeight);
  var maxImgWidth = 218;
  var maxImgHeight = 218;

  if (imgWidth > maxImgWidth || imgHeight > maxImgHeight) {
    imgFile.style.maxWidth="218px";
    imgFile.style.maxHeight="218px";
  }
  else if (imgWidth < maxImgWidth || imgHeight < maxImgHeight) {
    imgFile.style.minWidth="218px";
    imgFile.style.minHeight="218px";
  }
}


function artwork_small(imgFile) {
  var imgWidth = imgFile.width;
  var imgHeight = imgFile.height;
  console.log(imgWidth);
  console.log(imgHeight);
  var maxImgWidth = 195;
  var maxImgHeight = 195;

  if (imgWidth > maxImgWidth || imgHeight > maxImgHeight) {
    imgFile.style.maxWidth="195px";
    imgFile.style.maxHeight="195px";
  }
  else if (imgWidth < maxImgWidth || imgHeight < maxImgHeight) {
    imgFile.style.minWidth="195px";
    imgFile.style.minHeight="195px";
  }
}

//like 클릭
var likeClick = 0;
  function toggleImg() {
    if ( likeClick == 0 ) {
    document.getElementById("like").src="../resources/img/icon/like_2.png";
    likeClick = 1;
    console.log("heart1");

  }else {
    document.getElementById("img").src="../resources/img/icon/like.png";
    likeClick = 0;
    console.log("heart2");
  }
}

$(".likeButton").click(function() {
		//해당 Value값 가져와서 할당
		let userId = '<c:out value="${email}"/>';
		let targetValue = $(this).attr('value');
		console.log(userId);
		console.log(targetValue);
		$.ajax({
			type :'post',
			url : '<c:url value ="/likeUp"/>',
			contentType: 'application/json',
			data : JSON.stringify(
					{
						"userId" : userId,
						"targetValue" : targetValue,
						"likeNum" : 1
					}
				),
			context: this, 
			success : function(data) {
				alert(data.msg);
				let likeCheck = data.likeCheck;
				if(likeCheck == 1){
					$(this).$(".like_img").src="../resources/img/icon/like_2.png";
					console.log($(this));
				}else{
					$(this).$(".like_img").src="../resources/img/icon/like.png";
					console.log($(this));
				}
			},
			error : function(error) {
				alert(error);
			}
		})

	});//like

$("#alert1").on("click", function(){
	alert("내 상세 페이지를 먼저 등록해주세요.");
});