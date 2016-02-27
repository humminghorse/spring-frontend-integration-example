/*!
 * page-specific script for 'page-todos'
 */

/*
 * load deps
 */

var $ = require('jquery')

/*
 * define consts
 */

var TODOS_ENDPOINT = '/todos'

if (document.body.id === 'page-todos')
  $(init)

/**
 * Initialize after DOM tree structuring.
 */
function init() {
  $('#new-todo-form')
    .on('submit', onSubmitNewTodoForm)

  $('#todos')
    .on('click', '.delete', onClickDeleteTodo)

  $('#todos')
    .on('change', '[name=complete]', onChangeComplete)
}

/**
 * Handler for submitting new todo form.
 * Request to create the new todo, then add the todo into view.
 */
function onSubmitNewTodoForm(e) {
  e.preventDefault()

  var form = e.target
  $.ajax({
    url: TODOS_ENDPOINT,
    method: 'POST',
    data: $(form).serialize()
  }).done(function(todo, status, xhr) {
    $('#todos').append($('<li class="todo" data-todo-id="' + todo.id + '">' +
                         '  <input name="complete" type="checkbox"/>' +
                         '  <label>' + todo.title + '</label>' +
                         '  <button class="delete">×</button>' +
                         '</li>'))
    form.title.value = ''
  }).fail(function(xhr, status, err) {
    alert(status)
  })
}

/**
 * Handler for clicking delete todo button.
 * Request to destroy the clicked todo, then remove the todo from view.
 */
function onClickDeleteTodo(e) {
  var $todoEl = $(e.target).closest('.todo'),
      todoId = $todoEl.data('todo-id')

  var form = e.target
  $.ajax({
    url: TODOS_ENDPOINT + '/' + todoId,
    method: 'DELETE'
  }).done(function(data, status, xhr) {
    $(e.target).parents('li').remove()
  }).fail(function(xhr, status, err) {
    alert(status)
  })
}

/**
 * Handler for changing complete state.
 * Request to update the complete state.
 */
function onChangeComplete(e) {
  var $completeEl = $(e.target),
      $todoEl = $completeEl.closest('.todo'),
      todoId = $todoEl.data('todo-id')

  $.ajax({
    url: TODOS_ENDPOINT + '/' + todoId,
    method: 'PUT',
    data: {complete: $completeEl.prop('checked')}
  }).done(function(data, status, xhr) {
    $todoEl.toggleClass('completed', $completeEl.prop('checked'))
  }).fail(function(xhr, status, err) {
    $completeEl.prop('checked', !$completeEl.prop('checked'))
    alert(status)
  })
}
