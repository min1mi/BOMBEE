
  $(function() {
    $("#datepicker-start,#datepicker-end").datepicker({
      dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'],
      monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
      monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
      dateFormat: "yy-mm-dd",
      buttonText: "달력"
    });
  });

  $('#summernote').summernote({
    height: 250, // set editor height
    minHeight: null, // set minimum height of editor
    maxHeight: null, // set maximum height of editor
    focus: true // set focus to editable area after initializing summernote
  });

  function closeAlert() {
    alert('따당');
  }
