import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailContractDetailComponent } from './detail-contract-detail.component';

describe('DetailContractDetailComponent', () => {
  let component: DetailContractDetailComponent;
  let fixture: ComponentFixture<DetailContractDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailContractDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailContractDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
