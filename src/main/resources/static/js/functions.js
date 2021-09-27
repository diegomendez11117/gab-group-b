 $(function() {
      if(window.location.pathname == '/'){
           $('#navbar a').removeClass('active');
           $('a[href="/"]').addClass('active');

      } else if(window.location.href.indexOf('/wantTo') > -1){
           $('#navbar a').removeClass('active');
           $('a[href="/wantTo"]').addClass('active');

        } else if(window.location.href.indexOf('/about') > -1){
           $('#navbar a').removeClass('active');
           $('a[href="/about"]').addClass('active');

        } else if(window.location.href.indexOf('/help') > -1){
           $('#navbar a').removeClass('active');
           $('a[href="/help"]').addClass('active');

        } else if(window.location.href.indexOf('/account') > -1){
           $('#navbar a').removeClass('active');
           $('a[href="/account"]').addClass('active');
        }
     });