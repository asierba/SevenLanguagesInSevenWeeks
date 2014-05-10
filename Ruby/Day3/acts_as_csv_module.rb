#!/usr/bin/env ruby

module ActsAsCsv
  def self.included(base)
    base.extend ClassMethods
  end
  
  module ClassMethods
    def acts_as_csv
      include InstanceMethods
    end
  end
  
  module InstanceMethods   
    def read
      @csv_contents = []
      filename = self.class.to_s.downcase + '.txt'
      file = File.new(filename)
      @headers = file.gets.chomp.split(', ')

      file.each do |row|
        @csv_contents << row.chomp.split(', ')
      end
    end

    def each
      while @row_index < @csv_contents.size do
        yield CsvRow.new(@headers, @csv_contents[@row_index])
      	@row_index = @row_index + 1
      end
    end
    
    attr_accessor :headers, :csv_contents
    def initialize
      @row_index = 0
      read 
    end
  end
end

class RubyCsv  # no inheritance! You can mix it in
  include ActsAsCsv
  acts_as_csv
end

class CsvRow
  def initialize headers, data
    @headers = headers
    @data = data
  end

  def method_missing name, *args
    index = @headers.index name.to_s
    print @data[index] if index
  end 
end


csv = RubyCsv.new
csv.each {|row| puts row.one}
