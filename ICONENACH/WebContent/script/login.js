$('#login-form').submit(function (e) {
  e.preventDefault();
  var $form = $(this);
  console.log("ok1");

  // check if the input is valid using a 'valid' property
  if (!$form.valid) return false;
  console.log("ok2");
  $.ajax({
    type: 'POST',
    url: 'validate',
    data: $('#form').serialize(),
    success: function (response) {
      $('#result').html(response);
    },
  });
});