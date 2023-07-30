import { combineReducers } from 'redux';
import jobs from './jobs';
import visibilityFilter from './visibilityFilter';

const rootReducer = combineReducers({
  jobs,
  visibilityFilter,
});

export default rootReducer;