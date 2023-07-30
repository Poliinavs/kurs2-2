// // import React from 'react';
// // import React from 'react';
// // import ReactDOM from 'react-dom';
// interface Product {
//     category: string;
//     price: string;
//     stocked: boolean;
//     name: string;
//   }
  
//   interface ProductCategoryRowProps {
//     category: string;
//   }
  
//   class ProductCategoryRow extends React.Component<ProductCategoryRowProps> {
//     render() {
//       const category = this.props.category;
//       return (
//         <tr>
//           <th colSpan={2}>
//             {category}
//           </th>
//         </tr>
//       );
//     }
//   }
  
//   interface ProductRowProps {
//     product: Product;
//   }
  
//   class ProductRow extends React.Component<ProductRowProps> {
//     render() {
//       const product = this.props.product;
//       const name = product.stocked ?
//         product.name :
//         <span style={{color: 'red'}}>
//           {product.name}
//         </span>;
  
//       return (
//         <tr>
//           <td>{name}</td>
//           <td>{product.price}</td>
//         </tr>
//       );
//     }
//   }
  
//   interface ProductTableProps {
//     products: Product[];
//     filterText: string;
//     inStockOnly: boolean;
//   }
  
//   class ProductTable extends React.Component<ProductTableProps> {
//     render() {
//       const filterText = this.props.filterText;
//       const inStockOnly = this.props.inStockOnly;
  
//       const rows: React.ReactNode[] = [];
//       let lastCategory: string | null = null;
  
//       this.props.products.forEach((product) => {
//         if (product.name.indexOf(filterText) === -1) {
//           return;
//         }
//         if (inStockOnly && !product.stocked) {
//           return;
//         }
//         if (product.category !== lastCategory) {
//           rows.push(
//             <ProductCategoryRow
//               category={product.category}
//               key={product.category}
//             />
//           );
//         }
//         rows.push(
//           <ProductRow
//             product={product}
//             key={product.name}
//           />
//         );
//         lastCategory = product.category;
//       });
  
//       return (
//         <table>
//           <thead>
//             <tr>
//               <th>Name</th>
//               <th>Price</th>
//             </tr>
//           </thead>
//           <tbody>{rows}</tbody>
//         </table>
//       );
//     }
//   }
  
//   interface SearchBarProps {
//     filterText: string;
//     inStockOnly: boolean;
//     onFilterTextChange: (filterText: string) => void;
//     onInStockChange: (inStockOnly: boolean) => void;
//   }
  
//   class SearchBar extends React.Component<SearchBarProps> {
//     handleFilterTextChange = (e: React.ChangeEvent<HTMLInputElement>) => {
//       this.props.onFilterTextChange(e.target.value);
//     }
  
//     handleInStockChange = (e: React.ChangeEvent<HTMLInputElement>) => {
//       this.props.onInStockChange(e.target.checked);
//     }
  
//     render() {
//       return (
//         <form>
//           <input
//             type="text"
//             placeholder="Search..."
//             value={this.props.filterText}
//             onChange={this.handleFilterTextChange}
//           />
//           <p>
//             <input
//               type="checkbox"
//               checked={this.props.inStockOnly}
//               onChange={this.handleInStockChange}
//             />
//             {' '}
//             Only show products in stock
//           </p>
//         </form>
//       );
//     }
//   }
  
//   interface FilterableProductTableProps {
//     products: Product[];
//   }
  
//   interface FilterableProductTableState {
//     filterText: string;
//     inStockOnly: boolean;
//   }
  
//   class FilterableProductTable extends React.Component<FilterableProductTableProps, FilterableProductTableState> {
//     constructor(props: FilterableProductTableProps) {
//       super(props);
//       this.state = {
//         filterText: '',
//         inStockOnly: false
//       };