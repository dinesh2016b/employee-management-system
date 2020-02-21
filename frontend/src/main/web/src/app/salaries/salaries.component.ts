import { Component, OnInit } from '@angular/core';
import { Salaries } from '../model/salaries';
import { SalariesService } from '../service/salaries.service';

@Component({
  selector: 'app-salaries',
  templateUrl: './salaries.component.html',
  styleUrls: ['./salaries.component.css']
})

export class SalariesComponent implements OnInit {
  title = "Salaries List";
  salaries: Salaries[];

  constructor(private salariesService: SalariesService) { 

  }

  ngOnInit() {
    this.salariesService.findAll().subscribe(data => {
      this.salaries = data;
    });
  }
}