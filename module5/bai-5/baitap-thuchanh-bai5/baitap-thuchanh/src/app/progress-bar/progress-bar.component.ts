import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-progress-bar',
  templateUrl: './progress-bar.component.html',
  styleUrls: ['./progress-bar.component.scss']
})
export class ProgressBarComponent implements OnInit {
  @Input() backgroundColor = '#06d900';
  @Input() progressColor = '#af0b00';
  @Input() width = 50;
  constructor() { }

  ngOnInit() {
  }

}
