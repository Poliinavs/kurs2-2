import jobs from "./jobs";
import visibilityFilter from "./visibilityFilter";
import React from 'react';
import { VisibilityFilters } from '../actions';
import ReactDOM from 'react-dom';
import { jobTodo } from '../actions';
import { addJob } from '../actions';
import inform from '../inform';
import { setVisibilityFilter } from '../actions';

it('job should be liked', () => {
  let action = jobTodo(1);
  let state = inform;

  let newState = jobs(state, action);

  const jobWithId1 = newState.find((job: { id: number; }) => job.id === 1);  
  const liked = jobWithId1.liked;

  expect(liked).toBe(true);
});

describe('job should be added', () => {
  it('sets the visibility filter correctly', () => {
    let action = setVisibilityFilter("SHOW_ALL");
    let state = inform; 

    let newState = visibilityFilter(state, action);

    expect(newState).toBe(VisibilityFilters.SHOW_ALL);
  });
});

describe('filter should be changed', () => {
  it('sets the visibility filter correctly', () => {
    let action = setVisibilityFilter("SHOW_Like");
    let state = inform; 

    let newState = visibilityFilter(state, action);

    expect(newState).toBe(VisibilityFilters.SHOW_Like);
  
  });
});




it('job should be added', () => {

  var a ={
    name: 'Diagnocat',
    country: 'Италия',
    company: 'Frontend developer',
    data: '28/03/2021',
    spetial:  ["jQuery", "JavaScript", "CSS3","React", "Vue", "Flexbox"],
    zan:"staj",
    graph: "udal",
    min:10000,
    max:200000,
    experience:"no",
    liked:false
  }
  let action = addJob(a);
  let state = inform;

  let newState = jobs(state, action);
  expect(newState.length).toBe(5);
  expect(newState[4].id).toBe(5);

});

//3

