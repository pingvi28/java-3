//Область видимости переменной let – блок {...}.
//переменные let нельзя повторно объявлять

//Этот .each()метод разработан, чтобы сделать конструкции цикла DOM лаконичными и менее подверженными ошибкам.
// При вызове он выполняет итерацию по элементам DOM, которые являются частью объекта jQuery.
// Каждый раз, когда выполняется обратный вызов, ему передается текущая итерация цикла, начиная с 0.
// Что еще более важно, обратный вызов запускается в контексте текущего элемента DOM, поэтому ключевое слово this относится к элементу.

let video = ["jtUc1gigfQo","u13BVkpEkDo", "zd44dgITV_Y", "Hkz4SB6wJBM", "MF9gZ4GXIeY","BM9qm8ll3OI","Wvxf3IhhfEE","vaEJhCzMhzE","Qt0-9mO-ZXY","36xNGBBtMa0", "tJsGGsPNakw","UOS5CP8tzYQ","QgD5A2v3cp0","z0j6-IHnrrI","Qbq6LdKvxcM","L18e2-IZTNU","7NOSDKb0HlU","Yx1wtgBi7w0" ];

$( ".videoFrame" ).each(function() {
  let randomNum = Math.floor((Math.random() * video.length));
  $( this ).attr('src', "https://www.youtube.com/embed/" + video[randomNum] + "?showinfo=0&modestbranding=1&color=white&loop=1&playlist="+ video[randomNum]);
  video.splice(randomNum, 1);
});
