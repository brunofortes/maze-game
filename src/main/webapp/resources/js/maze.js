submitResult();

const LEFT = 'LEFT';
const RIGHT = 'RIGHT';
const TOP = 'TOP';
const DOWN = 'DOWN';		
const BACK = 'BACK';
const AHEAD = 'AHEAD';		

var stackActions = [];
var currentX;
var currentY;
var maxX;
var maxY;

function controlButtons(startX, startY, width, height){
	currentX = startX;
	currentY = startY;
	maxX = width;
	maxY = height;

	$('.btn-left').on('click', function(evt){
		executeAction(LEFT);
	});
	
	$('.btn-right').on('click', function(evt){
		executeAction(RIGHT);
	});

	$('.btn-top').on('click', function(evt){
		executeAction(TOP);
	});

	$('.btn-down').on('click', function(evt){
		executeAction(DOWN);		
	});	
	
	$(document).keydown(function(e) {
		switch(e.keyCode){
		case 37:
			executeAction(LEFT);
			e.preventDefault();
			break;
		case 38:
			executeAction(TOP);
			e.preventDefault();
			break;
		case 39:
			executeAction(RIGHT);
			e.preventDefault();
			break;
		case 40:
			executeAction(DOWN);
			e.preventDefault();
			break;
		}
	});	
}

function executeAction(action){
	if(validPosition(action)){
		var updateAction = action;
		if((stackActions.length > 0) &&
			(  (action == LEFT && stackActions[stackActions.length-1]==RIGHT)
			|| (action == RIGHT && stackActions[stackActions.length-1]==LEFT)
			|| (action == TOP && stackActions[stackActions.length-1]==DOWN)
			|| (action == DOWN && stackActions[stackActions.length-1]==TOP))){
			stackActions.pop(action);
			updateScreen(updateAction, BACK);
		} else {
			stackActions.push(action);
			updateScreen(updateAction, AHEAD);
		}		
	}	
}

function updateScreen(action, where){
	$('#li-y-'+currentY+' #li-x-'+currentX).removeClass('current');

	if(where == BACK){
		var passed = $('#li-y-'+currentY+' #li-x-'+currentX).data('passed');
		passed--;
		updatePassed(currentY, currentX, passed);
	}
	
	switch(action){
	case LEFT:
		currentX--;
		break;
	case RIGHT:
		currentX++;
		break;
	case TOP:
		currentY++;
		break;
	case DOWN:
		currentY--;
		break;
	}

	if(where == AHEAD){
		var passed = $('#li-y-'+currentY+' #li-x-'+currentX).data('passed');
		$('#li-y-'+currentY+' #li-x-'+currentX).addClass('selected');		
		passed++;
		updatePassed(currentY, currentX, passed);
	}
	
	$('#li-y-'+currentY+' #li-x-'+currentX).addClass('current');
	if($('.current').hasClass('end')){
		$('#modalSubmit').modal({
			backdrop:'static',
			keyboard:false
		});
	}
}

function updatePassed(currentY, currentX, passed){
	$('#li-y-'+currentY+' #li-x-'+currentX).data('passed', passed);
	$('#li-y-'+currentY+' #li-x-'+currentX).attr('data-passed', passed);
	if(passed == 0){
		$('#li-y-'+currentY+' #li-x-'+currentX).removeClass('selected');
	}
}

function validPosition(action){
	switch(action){
	case LEFT:
		return currentX - 1 > 0;
	case RIGHT:
		return currentX + 1 <= maxX;
	case TOP:
		return currentY + 1 <= maxY;
	case DOWN:
		return currentY - 1 > 0;
	}
	return false;
}

function submitResult(){
	$('.btn-submit').on('click', function(e){
		$.ajax({
			url : '/maze-0.0.1/solution/'+$('#input-id-maze').val(),
			method : "POST",
			data: JSON.stringify(stackActions),
			dataType : 'json',
			contentType: 'application/json;',
			complete: function(result){
				$('#div-maze-result').html(result.responseText);
				$('#modalSubmit').modal('hide');
				$('#modalResult').modal({
					backdrop:'static',
					keyboard:false
				});
		    }
		});
		e.preventDefault();
	});
}

function resizeMaze(width, height){
	$('#maze').width(Math.floor($('#maze').width() / width) * width);	
	$('.li-x').css("width", Math.floor($('#maze').width() / width));
	$('.li-x').css("height", Math.floor(($(window).height()-180) / height));
	$('#maze').height(Math.floor($('#maze').height() / height) * height);	
}
