import { Component, OnInit } from '@angular/core';
import { Operator } from '../model/Operator';
import { OperatorService } from '../services/operator.service';
import { Router } from '@angular/router';

@Component({
  selector: "app-operator",
  templateUrl: "./operator.component.html",
  styleUrls: ["./operator.component.css"],
})
export class OperatorComponent implements OnInit {
  listOperator!: Operator[];
  constructor(
    private operatorService: OperatorService,
    private route: Router
  ) {}
  ngOnInit(): void {
    this.operatorService.getOperators().subscribe({
      next: (data) => (this.listOperator = data),
    });
  }
}
