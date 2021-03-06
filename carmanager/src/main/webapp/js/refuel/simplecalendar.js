var calendar = {

  init: function() {

    var mon = 'Mon';
    var tue = 'Tue';
    var wed = 'Wed';
    var thur = 'Thur';
    var fri = 'Fri';
    var sat = 'Sat';
    var sund = 'Sun';

    /**
     * Get current date
     */
    var d = new Date();
    var strDate = yearNumber + "/" + (d.getMonth() + 1) + "/" + d.getDate();
    var yearNumber = (new Date).getFullYear();
    /**
     * Get current month and set as '.current-month' in title
     */
    var monthNumber = d.getMonth() + 1;

    function GetMonthName(monthNumber) {
      var months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
      return months[monthNumber - 1];
    }

    setMonth(monthNumber, mon, tue, wed, thur, fri, sat, sund);

    function setMonth(monthNumber, mon, tue, wed, thur, fri, sat, sund) {
      $('.month').text(GetMonthName(monthNumber) + ' ' + yearNumber);
      $('.month').attr('data-month', monthNumber);
      printDateNumber(monthNumber, mon, tue, wed, thur, fri, sat, sund);
    }

    $('.btn-next').on('click', function(e) {
      var monthNumber = $('.month').attr('data-month');
      if (monthNumber > 11) {
        $('.month').attr('data-month', '0');
        var monthNumber = $('.month').attr('data-month');
        yearNumber = yearNumber + 1;
        setMonth(parseInt(monthNumber) + 1, mon, tue, wed, thur, fri, sat, sund);
      } else {
        setMonth(parseInt(monthNumber) + 1, mon, tue, wed, thur, fri, sat, sund);
      };
      
    });

    $('.btn-prev').on('click', function(e) {
      var monthNumber = $('.month').attr('data-month');
      if (monthNumber < 2) {
        $('.month').attr('data-month', '13');
        var monthNumber = $('.month').attr('data-month');
        yearNumber = yearNumber - 1;
        setMonth(parseInt(monthNumber) - 1, mon, tue, wed, thur, fri, sat, sund);
      } else {
        setMonth(parseInt(monthNumber) - 1, mon, tue, wed, thur, fri, sat, sund);
      };
      
    });

    /**
     * Get all dates for current month
     */

    function printDateNumber(monthNumber, mon, tue, wed, thur, fri, sat, sund) {

      $($('tbody.event-calendar tr')).each(function(index) {
        $(this).empty();
      });

      $($('thead.event-days tr')).each(function(index) {
        $(this).empty();
      });

      function getDaysInMonth(month, year) {
        // Since no month has fewer than 28 days
        var date = new Date(year, month, 1);
        var days = [];
        while (date.getMonth() === month) {
          days.push(new Date(date));
          date.setDate(date.getDate() + 1);
        }
        return days;
      }

      i = 0;

      setDaysInOrder(mon, tue, wed, thur, fri, sat, sund);

      function setDaysInOrder(mon, tue, wed, thur, fri, sat, sund) {
        var monthDay = getDaysInMonth(monthNumber - 1, yearNumber)[0].toString().substring(0, 3);
        if (monthDay === 'Mon') {
          $('thead.event-days tr').append('<td>' + mon + '</td><td>' + tue + '</td><td>' + wed + '</td><td>' + thur + '</td><td>' + fri + '</td><td>' + sat + '</td><td>' + sund + '</td>');
        } else if (monthDay === 'Tue') {
          $('thead.event-days tr').append('<td>' + tue + '</td><td>' + wed + '</td><td>' + thur + '</td><td>' + fri + '</td><td>' + sat + '</td><td>' + sund + '</td><td>' + mon + '</td>');
        } else if (monthDay === 'Wed') {
          $('thead.event-days tr').append('<td>' + wed + '</td><td>' + thur + '</td><td>' + fri + '</td><td>' + sat + '</td><td>' + sund + '</td><td>' + mon + '</td><td>' + tue + '</td>');
        } else if (monthDay === 'Thu') {
          $('thead.event-days tr').append('<td>' + thur + '</td><td>' + fri + '</td><td>' + sat + '</td><td>' + sund + '</td><td>' + mon + '</td><td>' + tue + '</td><td>' + wed + '</td>');
        } else if (monthDay === 'Fri') {
          $('thead.event-days tr').append('<td>' + fri + '</td><td>' + sat + '</td><td>' + sund + '</td><td>' + mon + '</td><td>' + tue + '</td><td>' + wed + '</td><td>' + thur + '</td>');
        } else if (monthDay === 'Sat') {
          $('thead.event-days tr').append('<td>' + sat + '</td><td>' + sund + '</td><td>' + mon + '</td><td>' + tue + '</td><td>' + wed + '</td><td>' + thur + '</td><td>' + fri + '</td>');
        } else if (monthDay === 'Sun') {
          $('thead.event-days tr').append('<td>' + sund + '</td><td>' + mon + '</td><td>' + tue + '</td><td>' + wed + '</td><td>' + thur + '</td><td>' + fri + '</td><td>' + sat + '</td>');
        }
      };
      $(getDaysInMonth(monthNumber - 1, yearNumber)).each(function(index) {
        var index = index + 1;
        if (index < 8) {
          $('tbody.event-calendar tr.1').append('<td date-month="' + monthNumber + '" date-day="' + index + '" date-year="' + yearNumber + '">' + index + '</td>');
        } else if (index < 15) {
          $('tbody.event-calendar tr.2').append('<td date-month="' + monthNumber + '" date-day="' + index + '" date-year="' + yearNumber + '">' + index + '</td>');
        } else if (index < 22) {
          $('tbody.event-calendar tr.3').append('<td date-month="' + monthNumber + '" date-day="' + index + '" date-year="' + yearNumber + '">' + index + '</td>');
        } else if (index < 29) {
          $('tbody.event-calendar tr.4').append('<td date-month="' + monthNumber + '" date-day="' + index + '" date-year="' + yearNumber + '">' + index + '</td>');
        } else if (index < 32) {
          $('tbody.event-calendar tr.5').append('<td date-month="' + monthNumber + '" date-day="' + index + '" date-year="' + yearNumber + '">' + index + '</td>');
        }
        i++;
      });
      var date = new Date();
      var month = date.getMonth() + 1;
      var thisyear = new Date().getFullYear();
      setCurrentDay(month, thisyear);
      setEvent();
      displayEvent();
    }

    /**
     * Get current day and set as '.current-day'
     */
    
    /* 월 이동시 해당 연도/월 추출하기 */
    function setCurrentDay(month, year) {
      var viewMonth = $('.month').attr('data-month');
      var eventYear = $('.event-days').attr('date-year');
      if (parseInt(year) === yearNumber) {
        if (parseInt(month) === parseInt(viewMonth)) {
          $('tbody.event-calendar td[date-day="' + d.getDate() + '"]').addClass('current-day');
        }
      }
      // 달력에서 연도와 월 구하기
      var getMonth = viewMonth
      var getYear = yearNumber
      var getCalendarday = (getYear + '-' + getMonth);
      
      /* 월 이동시 평균 주유 값 출력하기 */
      //$.ajaxSetup({ async:false });
      $.getJSON('monthCost.do?no=' + sessionStorage.getItem('selectCarNo'), function(resultObj) {
        var costArray = null;
        var monthArray = null;
        var ajaxResult = resultObj.ajaxResult;
        var monthCost = ajaxResult.data;
        var monthPlusCost = null;
        if (ajaxResult.status == "success") {
          for (var mCost of monthCost) {
            costArray = mCost.cost;
            monthArray = mCost.group_date;
            monthPlusCost = (monthArray + '월은 ' + costArray);
            if (getCalendarday == monthArray) {
              $('#label_monMoney').html(monthPlusCost + '원 입니다.');
              break;
            } else {
              $('#label_monMoney').html(getCalendarday + '월 기록이 없습니다.');
            }
            
          }
        } 

      });
      
      
    };

    /**
     * Add class '.active' on calendar date
     */
    $('tbody td').on('click', function(e) {
      if ($(this).hasClass('event')) {
        $('tbody.event-calendar td').removeClass('active');
        $(this).addClass('active');
      } else {
        $('tbody.event-calendar td').removeClass('active');
      };
    });

    /**
     * Add '.event' class to all days that has an event
     */
    function setEvent() {
      $('.day-event').each(function(i) {
        var eventMonth = $(this).attr('date-month');
        var eventDay = $(this).attr('date-day');
        var eventYear = $(this).attr('date-year');
        var eventClass = $(this).attr('event-class');
        if (eventClass === undefined) eventClass = 'event';
        else eventClass = 'event ' + eventClass;

        if (parseInt(eventYear) === yearNumber) {
          $('tbody.event-calendar tr td[date-month="' + eventMonth + '"][date-day="' + eventDay + '"]').addClass(eventClass);
        }
      });
    };

    /**
     * Get current day on click in calendar
     * and find day-event to display
     */

    
    /* 날짜 클릭시 업데이트 폼으로 전환하기 */
    function displayEvent() {
      $('tbody.event-calendar td').on('click', function(e) {
        event.preventDefault();
        $('.day-event').slideUp('fast');
        var eventYear = $(this).attr('date-year');
        var monthEvent = $(this).attr('date-month');
        var eventDay = $(this).attr('date-day');
        var dayEvent = $(this).text();
        //$('.day-event[date-month="' + monthEvent + '"][date-day="' + dayEvent + '"]').slideDown('fast');
        var refuelValue = (eventYear + '-' + monthEvent + '-' + eventDay);
        //alert(typeof(refuelValue))
        //alert(eventYear);
        //alert(monthEvent);
        //alert(eventDay);
        //alert(refuelValue);
        
        // $('#addForm').css('display', 'none')
        // $('#updateForm').css('display', '')
        
        $('#moneyUP').css('display', 'none')
        $('#literUP').css('display', 'none')
        
        $('#sMoneyUP').click(function(event) {
          $('#moneyUP').css('display', '')
          $('#literUP').css('display', 'none')
        });
        $('#sLiterUP').click(function(event) {
          $('#moneyUP').css('display', 'none')
          $('#literUP').css('display', '')
        });
        
        
        $.getJSON('refuelOne.do?date=' + refuelValue + '&selectCar=' + sessionStorage.getItem('selectCarNo'), function(resultObj) {
          var ajaxResult = resultObj.ajaxResult;
          var refuelOne = ajaxResult.data;
          if (ajaxResult.status == "success") {
            swal("수정 페이지로 이동합니다 : )")
            $('#addForm').css('display', 'none');
            $('#updateForm').css('display', '');
            $("#date_refuelDateUP").val(refuelOne.refuelDate);
            $("#num_driveMileUP").val(refuelOne.mile);
            $("#num_literCostUP").val(refuelOne.literCost);
            $("#num_costUP").val(refuelOne.cost);
            $("#num_literUP").val(refuelOne.liter);
          } else if (ajaxResult.status == "failure") {
            $('#addForm').css('display', '');
            $('#updateForm').css('display', 'none');
            swal("해당 날짜의 주유기록이 없습니다 ; (", "주유기록이 있는 날짜를 클릭하세요.")
            return false;
          }
          
        });
       
         
        
      });
    };


    /**
     * Close day-event
     */
    $('.close').on('click', function(e) {
      $(this).parent().slideUp('fast');
    });

    /**
     * Save & Remove to/from personal list
     */
    $('.save').click(function() {
      if (this.checked) {
        $(this).next().text('Remove from personal list');
        var eventHtml = $(this).closest('.day-event').html();
        var eventMonth = $(this).closest('.day-event').attr('date-month');
        var eventDay = $(this).closest('.day-event').attr('date-day');
        var eventNumber = $(this).closest('.day-event').attr('data-number');
        $('.person-list').append('<div class="day" date-month="' + eventMonth + '" date-day="' + eventDay + '" data-number="' + eventNumber + '"style="display:none;">' + eventHtml + '</div>');
        $('.day[date-month="' + eventMonth + '"][date-day="' + eventDay + '"]').slideDown('fast');
        $('.day').find('.close').remove();
        $('.day').find('.save').removeClass('save').addClass('remove');
        $('.day').find('.remove').next().addClass('hidden-print');
        remove();
        sortlist();
      } else {
        $(this).next().text('Save to personal list');
        var eventMonth = $(this).closest('.day-event').attr('date-month');
        var eventDay = $(this).closest('.day-event').attr('date-day');
        var eventNumber = $(this).closest('.day-event').attr('data-number');
        $('.day[date-month="' + eventMonth + '"][date-day="' + eventDay + '"][data-number="' + eventNumber + '"]').slideUp('slow');
        setTimeout(function() {
          $('.day[date-month="' + eventMonth + '"][date-day="' + eventDay + '"][data-number="' + eventNumber + '"]').remove();
        }, 1500);
      }
    });

    function remove() {
      $('.remove').click(function() {
        if (this.checked) {
          $(this).next().text('Remove from personal list');
          var eventMonth = $(this).closest('.day').attr('date-month');
          var eventDay = $(this).closest('.day').attr('date-day');
          var eventNumber = $(this).closest('.day').attr('data-number');
          $('.day[date-month="' + eventMonth + '"][date-day="' + eventDay + '"][data-number="' + eventNumber + '"]').slideUp('slow');
          $('.day-event[date-month="' + eventMonth + '"][date-day="' + eventDay + '"][data-number="' + eventNumber + '"]').find('.save').attr('checked', false);
          $('.day-event[date-month="' + eventMonth + '"][date-day="' + eventDay + '"][data-number="' + eventNumber + '"]').find('span').text('Save to personal list');
          setTimeout(function() {
            $('.day[date-month="' + eventMonth + '"][date-day="' + eventDay + '"][data-number="' + eventNumber + '"]').remove();
          }, 1500);
        }
      });
    }

    /**
     * Sort personal list
     */
    function sortlist() {
      var personList = $('.person-list');

      personList.find('.day').sort(function(a, b) {
        return +a.getAttribute('date-day') - +b.getAttribute('date-day');
      }).appendTo(personList);
    }

    /**
     * Print button
     */
    $('.print-btn').click(function() {
      window.print();
    });

  },
};

$(document).ready(function() {
  calendar.init();
});