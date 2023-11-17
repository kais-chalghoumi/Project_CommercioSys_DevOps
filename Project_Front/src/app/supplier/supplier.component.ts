import { Component, OnInit } from "@angular/core";
import { SupplierService } from "../services/supplier.service";
import { NgbModal, ModalDismissReasons } from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: "app-supplier",
  templateUrl: "./supplier.component.html",
  styleUrls: ["./supplier.component.css"],
})
export class SupplierComponent implements OnInit {
  title = "kaddemFront";

  form: boolean = false;
  closeResult!: string;
  listSupplier: any;
  supplier!: any;

  constructor(private modalService: NgbModal, private ss: SupplierService) {}

  ngOnInit(): void {
    this.getAllSupplier();
    console.log(this.listSupplier);
    this.supplier = {
      idSupplier: null,
      code: null,
      label: null,
      supplierCategory: null,
    };
  }

  getAllSupplier() {
    return this.ss.getAllSupplier().subscribe((res) => {
      this.listSupplier = res;
    });
  }
  addSupplier(c: any) {
    this.ss.addSupplier(c).subscribe(() => {
      this.getAllSupplier();
      this.form = false;
    });
  }

  open(content: any, action: any) {
    if (action != null) this.supplier = action;
    else this.supplier = new this.supplier();
    this.modalService
      .open(content, { ariaLabelledBy: "modal-basic-title" })
      .result.then(
        (result) => {
          this.closeResult = `Closed with: ${result}`;
        },
        (reason) => {
          this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
        }
      );
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return "by pressing ESC";
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return "by clicking on a backdrop";
    } else {
      return `with: ${reason}`;
    }
  }

  cancel() {
    this.form = false;
  }
}
