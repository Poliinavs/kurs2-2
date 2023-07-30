

import { connect } from 'react-redux'
import { setVisibilityFilter } from '../action/actions'
import Link from '../components/Link'

interface StateProps {
  active: boolean;
}


const mapStateToProps = (state: any, ownProps: any):StateProps => ({
  active: ownProps.filter === state.visibilityFilter,
});

const mapDispatchToProps = (dispatch:any, ownProps: any) => ({
  onClick: () => dispatch(setVisibilityFilter(ownProps.filter)),
});

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Link)
