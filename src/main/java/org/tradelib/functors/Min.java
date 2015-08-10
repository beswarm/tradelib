// Copyright 2015 by Ivan Popivanov
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.tradelib.functors;

import com.google.common.collect.EvictingQueue;

public class Min {
   private int length;
   private int count;
   private EvictingQueue<Double> eq;
   
   public Min(int length) {
      this.length = length;
      this.count = 0;
      this.eq = EvictingQueue.create(this.length);
   }
   
   public int getLength() { return length; }
   public int getCount() { return count; }
   
   public void add(double value) {
      ++count;
      eq.add(value);
   }
   
   public double last() {
      return count < length ? Double.NaN : eq.stream().min(Double::compare).get();
   }
}
