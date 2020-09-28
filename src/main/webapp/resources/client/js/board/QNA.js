document.write("<script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js'></script>");

$(function() {
   
   var listNum = Number($('#list-length').val());
   var listNum2 = Number($('#list-length2').val());
   var listNum3 = Number(5);
   var searcheasy=1;
   
   $(document).ready(function() {
      qnaAll();
   })
   
   var qnaAll = function() {
      $("#moreList2").hide();
      $("#moreList").hide();
      $("#moreList3").hide();
      $("#list-length").show();
      $("#list-length2").hide();
      $("#list-length3").hide();
      $.ajax({
         type : "POST",
         url : "AllQNA.do",
         datatype : "json",
         data : {'listNum' : listNum},
         success : function(data) {
            $(".QNA-List-All").empty();
            var thead = "<tr class=listheadline>" +
                           "<th scope='col' class=tno>No</th><th scope='col' class=tname>작성자</th>" +
                           "<th scope='col' class=tcategory>카테고리</th><th scope='col' class=ttitle>제목</th>" + 
                           "<th scope='col' class=tsecret>비밀글</th><th scope='col' class=tdate>작성일</th>" +
                        "</tr>";
            var tbody;
            $.each(data, function(index, item) {
               var timestamp = item["claimQdate"];
               var date = new Date(timestamp);
               var formatdate = moment(date).format('YY.MM.DD HH:mm');
               var contentLink = item["claimTitle"];
               var secretIcon = item["claimSecret"];
               if(secretIcon == "공개") {
                  secretIcon = "<img src='resources/client/images/secretLock1.png' width=20px>";
                  contentLink = "<a href='QNAread.do?claimNum=" + item["claimNum"] + "'>" + item["claimTitle"];
               }
               else if (secretIcon == "비공개") {
               if ($('#clientId').val() == item["clientId"]) {
                  secretIcon = "<img src='resources/client/images/secretLock2.png' width=20px>";
                  contentLink = "<a href='QNAread.do?claimNum=" + item["claimNum"] + "'>" + item["claimTitle"];
               } else {
                  secretIcon = "<img src='resources/client/images/secretLock2.png' width=20px>";
                  contentLink = item["claimTitle"];
               }
               }
               tbody += "<tr><th class=tno>"   + (index+1)
               + "</th><th class=tname>" + item["clientName"]
               + "</th><th class=tcategory>" + item["claimCategory"]
               + "</th><th class=title>" + contentLink
               + "</th><th class=tsecret>" + secretIcon
               + "</th><th class=tdate>" + formatdate;
            });
            tbody += "</th></tr></table>";
            $(".QNA-List-All").append(thead);
            $(".QNA-List-All").append(tbody);
            if (data.length == listNum) {
               $("#moreList").show();
            }
            else {
               $("#moreList").hide();
            }
         }
      });
   };
   
   var myQna = function() {
         $("#moreList").hide();
         $("#moreList2").hide();
         $("#moreList3").hide();
         $("#list-length").hide();
         $("#list-length2").show();
         $("#list-length3").hide();
         console.log(listNum2);
         console.log($('#clientId').val());
         if ($('#clientId').val() != "") {
         $.ajax({
            type : "POST",
            url : "MyQNA.do",
            data : {'clientId' : $('#clientId').val(), 'listNum2' : listNum2},
            datatype : "json",
            success : function(data) {
               $(".QNA-List-All").empty();
               if (data.length == 0) {
                 $(".QNA-List-All").empty();
                   var table = "<table border=0 style='width: 836px;'><tr><th>작성하신 문의가 없습니다.</th></tr></table>";
                   $("#list-length2").hide();
                   $(".QNA-List-All").append(table);
              }
               else {
               var thead = "<tr class=listheadline>" +
               "<th scope='col' class=tno>No</th><th scope='col' class=tname>작성자</th>" +
               "<th scope='col' class=tcategory>카테고리</th><th scope='col' class=ttitle>제목</th>" + 
               "<th scope='col' class=tadate>등록</th><th scope='col' class=tdate>작성일</th>" +
               "</tr>";
               var tbody;
               $.each(data, function(index, item) {
                  var timestamp = item["claimQdate"];
                  var date = new Date(timestamp);
                  var formatdate = moment(date).format('YY.MM.DD HH:mm');
                  var claimcheck = item["claimAdate"];
                  if(claimcheck != "") {
                     claimcheck = "<img src='resources/client/images/checkYes.png' width=20px>";
                  }
                  else {
                     claimcheck = "<img src='resources/client/images/checkNo.png' width=20px>";
                  }
                  tbody += "<tr><th class=tno>"   + (index+1)
                  + "</th><th class=tname>" + item["clientName"]
                  + "</th><th class=tcategory>" + item["claimCategory"]
                  + "</td><td class=title>" + "<a href='QNAread.do?claimNum=" + item["claimNum"] + "'>" + item["claimTitle"]
                  + "</td><td class=tadate>" + claimcheck
                  + "</th><th class=tdate>" + formatdate;
               });
               tbody += "</th></tr></table>";
               $(".QNA-List-All").append(thead);
               $(".QNA-List-All").append(tbody);
               if (data.length == listNum2) {
                  $("#moreList2").show();
               }
               else {
                  $("#moreList2").hide();
               }
            }
            }
         });
         }
         else {
            $(".QNA-List-All").empty();
            var table = "<table border='0' style='width: 836px;'><tr><th>로그인 후 확인이 가능합니다.</th></tr></table>";
            $("#list-length2").hide();
            $(".QNA-List-All").append(table);
         }
      };
   
   var searchQna = function() {
      $("#moreList").hide();
      $("#moreList2").hide();
      $("#moreList3").hide();
      $("#list-length").hide();
      $("#list-length2").hide();
      $("#list-length3").show();
      var searchfor = 0;
      var searchadd = 0;
      var searchItem = "";
      if ($("#search-Type").val() == 0) {
         searchfor = 0;
         searchItem = "%"+$("#search-Content").val()+"%";
      }
      else if ($("#search-Type").val() == 1) {
         searchfor = 1;
         searchItem = "%"+$("#search-Content").val()+"%";
      }
      else if ($("#search-Type").val() == 2) {
         searchfor = 2;
         searchItem = "%"+$("#search-Content").val()+"%";
      }
      else if ($("#search-Type").val() == 3){
         searchfor = 3;
         searchItem = "%"+$("#search-Content").val()+"%";
      }
      $.ajax({
         type : "POST",
         url : "SearchQNA.do",
         data : {"searchfor" : searchfor, "searchItem" : searchItem, "listNum3" : listNum3},
         datatype : "json",
         success : function(data) {
            $(".QNA-List-All").empty();
            var thead = "<tr class=listheadline>" +
            "<th scope='col' class=tno>No</th><th scope='col' class=tname>작성자</th>" +
            "<th scope='col' class=tcategory>카테고리</th><th scope='col' class=ttitle>제목</th>" + 
            "<th scope='col' class=tsecret>비밀글</th><th scope='col' class=tdate>작성일</th>" +
            "</tr>";
            var tbody;
            $.each(data, function(index, item) {
               var timestamp = item["claimQdate"];
               var date = new Date(timestamp);
               var formatdate = moment(date).format('YY.MM.DD HH:mm');
               var contentLink = item["claimTitle"];
               var secretIcon = item["claimSecret"];
               if(secretIcon == "공개") {
                  secretIcon = "<img src='resources/client/images/secretLock1.png' width=20px>";
                  contentLink = "<a href='QNAread.do?claimNum=" + item["claimNum"] + "'>" + item["claimTitle"];
               }
               else if (secretIcon == "비공개") {
               if ($('#clientId').val() == item["clientId"]) {
                  secretIcon = "<img src='resources/client/images/secretLock2.png' width=20px>";
                  contentLink = "<a href='QNAread.do?claimNum=" + item["claimNum"] + "'>" + item["claimTitle"];
               } else {
                  secretIcon = "<img src='resources/client/images/secretLock2.png' width=20px>";
                  contentLink = item["claimTitle"];
               }
               }
               tbody += "<tr><th class=tno>"   + (index+1)
               + "</th><th class=tname>" + item["clientName"]
               + "</th><th class=tcategory>" + item["claimCategory"]
               + "</th><th class=title>" + contentLink
               + "</th><th class=tsecret>" + secretIcon
               + "</th><th class=tdate>" + formatdate;
            });
            tbody += "</th></tr></table>";
            $(".QNA-List-All").append(thead);
            $(".QNA-List-All").append(tbody);
            if (data.length == listNum3) {
               $("#moreList3").show();
            }
            else {
               $("#moreList3").hide();
            }
         }
      });
   };
   
   var searchQna2 = function() {
         $("#moreList").hide();
         $("#moreList2").hide();
         $("#moreList3").hide();
         $("#list-length").hide();
         $("#list-length2").hide();
         $("#list-length3").show();
         var searchfor = 0;
         var searchadd = 0;
         var searchItem = "";
         if (searcheasy == 0){
             searchfor = 0;
             searchItem = "%"+$("#search-Content2").val()+"%";
         }
         $.ajax({
            type : "POST",
            url : "SearchQNA.do",
            data : {"searchfor" : searchfor, "searchItem" : searchItem, "listNum3" : listNum3},
            datatype : "json",
            success : function(data) {
               $(".QNA-List-All").empty();
               var thead = "<tr class=listheadline>" +
               "<th scope='col' class=tno>No</th><th scope='col' class=tname>작성자</th>" +
               "<th scope='col' class=tcategory>카테고리</th><th scope='col' class=ttitle>제목</th>" + 
               "<th scope='col' class=tsecret>비밀글</th><th scope='col' class=tdate>작성일</th>" +
               "</tr>";
               var tbody;
               $.each(data, function(index, item) {
                  var timestamp = item["claimQdate"];
                  var date = new Date(timestamp);
                  var formatdate = moment(date).format('YY.MM.DD HH:mm');
                  var contentLink = item["claimTitle"];
                  var secretIcon = item["claimSecret"];
                  if(secretIcon == "공개") {
                     secretIcon = "<img src='resources/client/images/secretLock1.png' width=20px>";
                     contentLink = "<a href='QNAread.do?claimNum=" + item["claimNum"] + "'>" + item["claimTitle"];
                  }
                  else if (secretIcon == "비공개") {
                  if ($('#clientId').val() == item["clientId"]) {
                     secretIcon = "<img src='resources/client/images/secretLock2.png' width=20px>";
                     contentLink = "<a href='QNAread.do?claimNum=" + item["claimNum"] + "'>" + item["claimTitle"];
                  } else {
                     secretIcon = "<img src='resources/client/images/secretLock2.png' width=20px>";
                     contentLink = item["claimTitle"];
                  }
                  }
                  tbody += "<tr><th class=tno>"   + (index+1)
                  + "</th><th class=tname>" + item["clientName"]
                  + "</th><th class=tcategory>" + item["claimCategory"]
                  + "</th><th class=title>" + contentLink
                  + "</th><th class=tsecret>" + secretIcon
                  + "</th><th class=tdate>" + formatdate;
               });
               tbody += "</th></tr></table>";
               $(".QNA-List-All").append(thead);
               $(".QNA-List-All").append(tbody);
               if (data.length == listNum3) {
                  $("#moreList3").show();
               }
               else {
                  $("#moreList3").hide();
               }
            }
         });
      };
   
   $("#Selected1").on('mouseenter', qnaAll);
   
   $("#Selected2").on('mouseenter', myQna);
   
   $("#sideSelected1").on('click', qnaAll);
   
   $("#sideSelected2").on('click', myQna);
   
   $("#moreList").on('click', function() {
      listNum += Number($('#list-length').val());
      qnaAll();
   });
   
   $("#moreList2").on('click', function() {
      listNum2 += Number($('#list-length2').val());
      myQna();
   });
   
   $("#moreList3").on('click', function() {
      listNum3 += Number($('#list-length3').val());
      searchQna();
   });
   
   $("#search-Btn").on('click', function() {
      searchQna();
   });
   
   $("#search-Btn2").on('click', function() {
      searcheasy = 0;
      searchQna2();
   });

   $("#list-length").on('change', function() {
      listNum = Number($('#list-length').val());
      qnaAll();
   })
   $("#list-length2").on('change', function() {
      listNum2 = Number($('#list-length2').val());
      myQna();
   })
   $("#list-length3").on('change', function() {
      listNum3 = Number($('#list-length3').val());
      searchQna();
   })
});