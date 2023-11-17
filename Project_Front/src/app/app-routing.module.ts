import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductComponent } from './product/product.component';
import { StockComponent } from './stock/stock.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ContactComponent } from './contact/contact.component';
import { OperatorComponent } from './operator/operator.component';
import { AddOperatorComponent } from './add-operator/add-operator.component';

const routes: Routes = [
  { path: "", redirectTo: "/operator", pathMatch: "full" },
  { path: "operator", component: OperatorComponent },
  { path: "add-Operator", component: AddOperatorComponent },
  { path: "home", component: StockComponent },
  { path: "products", component: ProductListComponent },
  { path: "product/:id", component: ProductComponent },
  { path: "contact", component: ContactComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
