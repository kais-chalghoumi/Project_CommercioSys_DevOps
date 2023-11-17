import { Component, OnInit } from '@angular/core';
import { Operator } from '../model/Operator';
import { OperatorService } from '../services/operator.service';
import { Router } from '@angular/router';

@Component({
  selector: "app-add-operator",
  templateUrl: "./add-operator.component.html",
  styleUrls: ["./add-operator.component.css"],
})
export class AddOperatorComponent implements OnInit {
  operator!: Operator;
  constructor(
    private operatorService: OperatorService,
    private route: Router
  ) {}
  ngOnInit(): void {
    this.operator = new Operator();
  }
  ajouter() {
    this.operatorService.postOperator(this.operator).subscribe({
      next: () => this.route.navigate(['/Operator']),
    });
  }
}
