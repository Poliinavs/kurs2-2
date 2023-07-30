
import React from 'react'
import PropTypes from 'prop-types'
import { VisibilityFilters } from '../actions';
import lenguage from '../containers/VisibleJobList';
import TextField from '@material-ui/core/TextField';


import '../style/Link.css';

const Text = ({ active,  onChange }) => (
  <TextField
  id="standard-basic"

  onBlur={onChange}
  style={{
    marginTop: '0px',
  }}
/>
  //   <input
  //   type='text'
    
  //   onBlur={onChange}
  //   style={{
  //     marginLeft: '4px',
  //   }}
  // />

)



export default Text
