document.write("<script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js'></script>");

$(function() {
   
   var listNum = Number($('#list-length').val());
   var listNum2 = Number($('#list-length2').val());
   var listNum3 = Number(5);
   
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
            $(".getList").empty();
            var table = "<table border=0 id='Selected1-dd' class='showlist'>"
               +"<tr class=listheadline><td class=tno>No</td><td class=tname>작성자</td><td class=tcategory>카테고리</td>"
               + "<td class=ttitle>제목</td><td class=tsecret>비밀글</td><td class=tdate>작성일</td></tr>";
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
               table += "<tr><td class=tno>"   + (index+1)
               + "</td><td class=tname>" + item["clientName"]
               + "</td><td class=tcategory>" + item["claimCategory"]
               + "</td><td class=title>" + contentLink
               + "</tdi><td class=tsecret>" + secretIcon
               + "</td><td class=tdate>" + formatdate;
               console.log(item["claimTitle"].length);
            });
            table += "</td></tr></table>";
            $(".getList").append(table);
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
      if ($('#clientId').val() != "") {
      $.ajax({
         type : "POST",
         url : "MyQNA.do",
         data : {'clientId' : $('#clientId').val(), 'listNum2' : listNum2},
         datatype : "json",
         success : function(data) {
            $(".getList").empty();
            /*$(".getList").empty();*/
            var table = "<table border=0 id='Selected1-dd' class='showlist2'>"
               +"<tr class=listheadline><td class=tno>No</td><td class=tname>작성자</td><td class=tcategory>카테고리</td>"
               + "<td class=ttitle>제목</td><td class=tdate>작성일</td><td class=tadate>답변</td></tr>";
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
               table += "<tr><td class=tno>"   + (index+1)
               + "</td><td class=tname>" + item["clientName"]
               + "</td><td class=tcategory>" + item["claimCategory"]
               + "</td><td class=title>" + "<a href='QNAread.do?claimNum=" + item["claimNum"] + "'>" + item["claimTitle"]
               + "</td><td class=tdate>" + formatdate
               + "</td><td class=tadate>" + claimcheck;
            });
            table += "</td></tr></table>";
            $(".getList").append(table);
            console.log(data.length);
            if (data.length == listNum2) {
               $("#moreList2").show();
            }
            else {
               $("#moreList2").hide();
            }
         }
      });
      }
      else {
         $(".getList").empty();
         var table = "회원 정보 확인이 어렵습니다.";
         $("#list-length2").hide();
         $(".getList").append(table);
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
      else {
         searchfor = 3;
         searchItem = "%"+$("#search-Content").val()+"%";
      }
     /* alert($("#search-Type").val());*/
      $.ajax({
         type : "POST",
         url : "SearchQNA.do",
         data : {"searchfor" : searchfor, "searchItem" : searchItem, "listNum3" : listNum3},
         datatype : "json",
         success : function(data) {
            $(".getList").empty();
            console.log(searchItem);
            var table = "<table border=0 id='Selected1-dd' class='showlist3'>"
               +"<tr class=listheadline><td class=tno>No</td><td class=tname>작성자</td><td class=tcategory>카테고리</td>"
               + "<td class=ttitle>제목</td><td class=tsecret>비밀글</td><td class=tdate>작성일</td></tr>";
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
               table += "<tr><td class=tno>"   + (index+1)
               + "</td><td class=tname>" + item["clientName"]
               + "</td><td class=tcategory>" + item["claimCategory"]
               + "</td><td class=title>" + contentLink
               + "</tdi><td class=tsecret>" + secretIcon
               + "</td><td class=tdate>" + formatdate;
               console.log(item["claimTitle"].length);
            });
            table += "</td></tr></table>";
            $(".getList").append(table);
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
      /*$("#moreList2").hide();
      $("#moreList").show();*/
      listNum += Number($('#list-length').val());
      qnaAll();
   });
   
   $("#moreList2").on('click', function() {
      /*$("#moreList").hide();
      $("#moreList2").show();*/
      listNum2 += Number($('#list-length2').val());
      myQna();
   });
   
   $("#moreList3").on('click', function() {
      /*$("#moreList").hide();
      $("#moreList2").show();*/
      listNum3 += Number($('#list-length3').val());
      searchQna();
   });
   
   $("#search-Btn").on('click', function() {
      searchQna();
   });

   $("#list-length").on('change', function() {
      listNum = Number($('#list-length').val());
      console.log(listNum);
      qnaAll();
   })
   $("#list-length2").on('change', function() {
      listNum2 = Number($('#list-length2').val());
      console.log(listNum);
      myQna();
   })
   $("#list-length3").on('change', function() {
      listNum3 = Number($('#list-length3').val());
      console.log(listNum);
      searchQna();
   })
});