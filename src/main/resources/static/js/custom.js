function showAndHide(toHide, toShow) {
	$(toHide).addClass('hidden');
	$(toShow).fadeIn(1000);
	$(toShow).removeClass('hidden');
}

function submittingEvent() {
	var submitedData = {}
	submitedData = $("#new_event").serialize();

	var formData = {};

	var $form = $("#new_event"), formData = new FormData(), params = $form
			.serializeArray(), files = $form.find('[name="eventLogo"]')[0].files;

	$.each(files, function(i, file) {
		formData.append('attachement-' + i, file);
	});

	$.each(params, function(i, val) {
		formData.append(val.name, val.value);
	});

	$.ajax({
		type : "POST",
		url : 'app/formSubmission/newEvent',
		cache : false,
		contentType : false,
		processData : false,
		data : formData,
		success : function(data) {
			if (data == 'New Record is Successfully saved') {
				new PNotify({
					title : 'Left icon',
					text : data,
					addclass : 'alert alert-styled-left',
					type : 'info'
				});
				setTimeout(function() {// wait for 2 secs(2)
					location.href = "dashboard"; // then return to tasks
					// page.(3)
				}, 1000);
			} else {
				new PNotify({
					title : 'Error',
					text : data,
					addclass : 'alert alert-styled-left',
					type : 'error'
				});
			}

		},
		error : function(e) {
			console.log("ERROR: ", e);
		}
	})
}

function editEvent() {
	var submitedData = {}
	submitedData = $("#edit_event").serialize();

	var formData = {};

	var $form = $("#edit_event"), formData = new FormData(), params = $form
			.serializeArray(), files = $form.find('[name="eventLogo"]')[0].files;

	$.each(files, function(i, file) {
		formData.append('attachement-' + i, file);
	});

	$.each(params, function(i, val) {
		formData.append(val.name, val.value);
	});

	$.ajax({
		type : "POST",
		url : 'app/formSubmission/editEvent',
		cache : false,
		contentType : false,
		processData : false,
		data : formData,
		success : function(data) {
			if (data == 'Record is Successfully updated') {
				new PNotify({
					title : 'Left icon',
					text : data,
					addclass : 'alert alert-styled-left',
					type : 'info'
				});
				setTimeout(function() {// wait for 2 secs(2)
					location.href = "dashboard"; // then return to tasks
					// page.(3)
				}, 1000);
			} else {
				new PNotify({
					title : 'Error',
					text : data,
					addclass : 'alert alert-styled-left',
					type : 'error'
				});
			}

		},
		error : function(e) {
			console.log("ERROR: ", e);
		}
	})
}

(function() {
	$('#new_event').submit('click', function(event) {
		event.preventDefault();
		submittingEvent();
	});
	$('#edit_event').submit('click', function(event) {
		event.preventDefault();
		editEvent();
	});
})();

(function() {
	$("#new_survey").submit('click', function(event) {
		event.preventDefault();
		createSurvey();
	});
	$('#new_question').submit('click', function(event) {
		event.preventDefault();
		createQuestion();
	});

	$('#choiceForm').submit('click', function(event) {
		event.preventDefault();
		createChoice();
	});

	$('#register_form').submit('click', function(event) {
		event.preventDefault();
		createUserAccount();
	});

	$('#submit_answers').submit('click', function(event) {
		event.preventDefault();
		submitAnswers();
	});
	$("#mce").change(function() {

		var selectedValue = $("#mce option:selected").attr('value');
		drawDonut(selectedValue);
	});

	$("#oe").change(function() {

		var selectedValue = $("#oe option:selected").attr('value');
		publishData(selectedValue);
	});

	$('.editSurvey').submit('click', function(event) {
		event.preventDefault();
		var surveyId = $(this).attr('id');
		editSurvey(surveyId);
	});

	$('.deleteSurvey').submit('click', function(event) {
		event.preventDefault();
		var surveyId = $(this).attr('id');
		deleteSurvey(surveyId);
	});

	$('.editQuestion').submit('click', function(event) {
		event.preventDefault();
		var questionId = $(this).attr('id');
		updateQuestion(questionId);
	});

	$('.deleteQuestion').submit('click', function(event) {
		event.preventDefault();
		var questionId = $(this).attr('id');
		deleteQuestion(questionId);
	});

	$('#post_idea').submit('click', function(event) {
		event.preventDefault();
		postIdea();

	});

	$('.add_comment').submit('click', function(event) {
		event.preventDefault();
		var postId = $(this).attr('id');
		addComment(postId);
	});

	$('.postComment').click(function(event) {
		event.preventDefault();
		var postId = $(this).attr('id');
		postComments(postId)
	});

	$('.likePost').click(function(event) {
		event.preventDefault();
		var postId = $(this).attr('id');
		likePost(postId);
	});

	$('.followUser').click(function(event) {
		event.preventDefault();
		var username = $(this).attr('id');
		followUser(username);
	});

	$('.sharePost').click(function(event) {
		event.preventDefault();
		var postId = $(this).attr('id');
		sharePost(postId);
	});
})();

function createSurvey() {
	var formData = {};
	formData = $('#new_survey').serialize();
	$.ajax({
		url : 'http://localhost:8080/formSubmission/survey',
		method : 'POST',
		data : formData,
		success : function(data) {
			if (data == 'Record is successfully saved!') {
				new PNotify({
					title : 'Success',
					text : data,
					addclass : 'alert alert-styled-left',
					type : 'info'
				});
				setTimeout(function() {
					location.reload();
				}, 1000)
			} else {
				new PNotify({
					title : 'Failure',
					text : data,
					addclass : 'alert alert-styled-left',
					type : 'error'
				});
			}
		}
	})
}

function editSurvey(surveyId) {
	var formData = {};
	formData = $('#' + surveyId).serialize();
	$.ajax({
		url : 'http://localhost:8080/formSubmission/editSurvey',
		method : 'POST',
		data : formData,
		success : function(data) {
			if (data == 'Record is successfully edited') {
				new PNotify({
					title : 'Success',
					text : data,
					addclass : 'alert alert-styled-left',
					type : 'info'
				});
				setTimeout(function() {
					location.reload();
				}, 1000)
			} else {
				new PNotify({
					title : 'Failure',
					text : data,
					addclass : 'alert alert-styled-left',
					type : 'error'
				});
			}
		}
	})
}

function deleteSurvey(surveyId) {
	var formData = {};
	formData = $('#' + surveyId).serialize();
	$.ajax({
		url : 'http://localhost:8080/formSubmission/deleteSurvey',
		method : 'POST',
		data : formData,
		success : function(data) {
			if (data == 'Record is successfully deleted') {
				new PNotify({
					title : 'Success',
					text : data,
					addclass : 'alert alert-styled-left',
					type : 'info'
				});
				setTimeout(function() {
					location.reload();
				}, 1000)
			} else {
				new PNotify({
					title : 'Failure',
					text : data,
					addclass : 'alert alert-styled-left',
					type : 'error'
				});
			}
		}
	})
}

function publishData(choosenValue) {
	var element = '';
	$
			.ajax({
				url : 'http://localhost:8080/formSubmission/openQuestions_'
						+ choosenValue,
				method : 'POST',
				data : choosenValue,
				async : false,
				success : function(data) {
					var result = $.parseJSON(data);
					for (var i = 0; i < result.length; i++) {
						element += '<div style="padding:20px;border:1px solid #ddd;border-radius:5px;width:80%;margin-left:1%;">';
						element += result[i].value;
						element += '</div>';
						element += '<div style="height : 5px;"></div>';
					}
				}
			})
	$('#openEnd').empty();
	$('#openEnd').append(element);
}

function createQuestion() {
	var formData = {};
	formData = $('#new_question').serialize();
	var url1 = 'http://localhost:8080/formSubmission/question'
	$.ajax({
		url : url1,
		method : 'POST',
		data : formData,
		success : function(data) {
			if (data == 'Record is successfully saved!') {
				new PNotify({
					title : 'Success',
					text : data,
					addclass : 'alert alert-styled-left',
					type : 'info'
				});
				setTimeout(function() {
					location.reload();
				}, 1000)
			} else {
				new PNotify({
					title : 'Failure',
					text : data,
					addclass : 'alert alert-styled-left',
					type : 'error'
				});
			}
		}
	})
}

function deleteQuestion(questionId) {
	var formData = {};
	formData = $('#' + questionId).serialize();
	$.ajax({
		url : 'http://localhost:8080/formSubmission/deleteQuestion',
		method : 'POST',
		data : formData,
		success : function(data) {
			if (data == 'Record is successfully deleted') {
				new PNotify({
					title : 'Success',
					text : data,
					addclass : 'alert alert-styled-left',
					type : 'info'
				});
				setTimeout(function() {
					location.reload();
				}, 1000)
			} else {
				new PNotify({
					title : 'Failure',
					text : data,
					addclass : 'alert alert-styled-left',
					type : 'error'
				});
			}
		}
	})
}

function updateQuestion(questionId) {
	var formData = {};
	formData = $('#' + questionId).serialize();
	var url1 = 'http://localhost:8080/formSubmission/editQuestion'
	$.ajax({
		url : url1,
		method : 'POST',
		data : formData,
		success : function(data) {
			if (data == 'Record is successfully edited') {
				new PNotify({
					title : 'Success',
					text : data,
					addclass : 'alert alert-styled-left',
					type : 'info'
				});
				setTimeout(function() {
					location.reload();
				}, 1000)
			} else {
				new PNotify({
					title : 'Failure',
					text : data,
					addclass : 'alert alert-styled-left',
					type : 'error'
				});
			}
		}
	})
}

function createChoice() {
	var formData = {};
	formData = $('#choiceForm').serialize();
	$.ajax({
		url : 'http://localhost:8080/formSubmission/choice',
		method : 'POST',
		data : formData,
		success : function(data) {
			if (data == 'Record is successfully saved!') {
				new PNotify({
					title : 'Success',
					text : data,
					addclass : 'alert alert-styled-left',
					type : 'info'
				});
				setTimeout(function() {
					location.reload();
				}, 1000)
			} else {
				failureMessage(data);
			}
		}
	})
}

function createUserAccount() {
	var formData = $('#register_form').serialize();
	alert(formData);
	$.ajax({
		url : 'formSubmission/createAccount',
		method : 'POST',
		data : formData,
		success : function(data) {
			if (data == 'Record is successfully saved') {
				successMessage('Account is scuccessfully created');
			} else {
				failureMessage(data);
			}
		}
	})
}

function submitAnswers() {
	var submitedData = $('#submit_answers').serialize();
	$
			.ajax({
				url : 'formSubmission/submitAnswers',
				method : 'POST',
				data : submitedData,
				success : function(data) {
					if (data == 'Survey is successfully submited,thanks for your participation') {
						new PNotify({
							title : 'Success',
							text : data,
							addclass : 'alert alert-styled-left',
							type : 'info'
						});
						setTimeout(function() {
							location.href = "resultPage";
						}, 1000)

					} else {
						failureMessage(data);
					}
				}
			})
}

function postIdea() {
	var formData = $('#post_idea').serialize();
	$.ajax({
		url : 'formSubmission/addPost',
		method : 'POST',
		data : formData,
		success : function(data) {
			if (data == 'Record is successfully saved') {
				successMessage(data);
			} else {
				failureMessage(data);
			}
		}
	})
}

function addComment(postId) {
	var formData = $('#addedComment_' + postId).serialize();

	var content = $('#comment_' + postId).val();

	$.ajax({
		url : 'formSubmission/addComment_' + postId,
		method : 'POST',
		data : {
			'content' : content
		},
		success : function(data) {
			if (data == 'Record is successfully saved') {
				successMessage(data);
			} else {
				failureMessage(data);
			}
		}
	})
}

function likePost(postId) {
	$.ajax({
		url : 'formSubmission/likePost_' + postId,
		method : 'POST',
		data : postId,
		success : function(data) {
			if (data == 'Record is successfully saved') {
				successMessage(data);
			} else {
				failureMessage(data);
			}
		}
	})
}

function followUser(user) {
	$.ajax({
		url : 'formSubmission/followUser',
		method : 'POST',
		data : {
			'username' : user
		},
		success : function(data) {
			if (data == 'Record is successfully saved') {
				successMessage(data);
			} else {
				failureMessage(data);
			}
		}
	})
}

function sharePost(postId) {
	$.ajax({
		url : 'formSubmission/sharePost',
		method : 'POST',
		data : {
			'postId' : postId
		},
		success : function(data) {
			if (data == 'Record is successfully saved') {
				successMessage(data);
			} else {
				failureMessage(data);
			}
		}
	})
}

function successMessage(data) {
	new PNotify({
		title : 'Success',
		text : data,
		addclass : 'alert alert-styled-left',
		type : 'info'
	});
	setTimeout(function() {
		location.reload();
	}, 1000)
}

function failureMessage(data) {
	new PNotify({
		title : 'Failure',
		text : data,
		addclass : 'alert alert-styled-left',
		type : 'error'
	});
}

function postComments(postId) {

	$('#actions_' + postId).addClass('hidden');
	$('#results_' + postId).fadeIn(1000);
	$('#results_' + postId).removeClass('hidden');
}

// function to register invited applicant

