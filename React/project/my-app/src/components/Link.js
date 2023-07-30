
import React from 'react'
import PropTypes from 'prop-types'
import { VisibilityFilters } from '../actions';
import lenguage from '../containers/VisibleJobList';


import '../style/Link.css';

const Link = ({ active, children, onClick }) => (
    <a
       onClick={onClick}
       disabled={active}
       lenguage={children}
       style={{
           marginLeft: '4px',
       }}
    >
      {children}
    </a>
)



export default Link
